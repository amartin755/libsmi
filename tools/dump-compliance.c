/*
 * dump-compliances.c --
 *
 *      Operations to dump compliances in a human readable format.
 *
 * Copyright (c) 2005 J. Schoenwaelder, International University Bremen.
 *
 * See the file "COPYING" for information on usage and redistribution
 * of this file, and for a DISCLAIMER OF ALL WARRANTIES.
 *
 * @(#) $Id: dump-compliances.c 1571 2003-07-14 22:58:42Z schoenw $
 */

#include <config.h>

#include <stdio.h>
#include <string.h>

#include "smi.h"
#include "smidump.h"


static char *getFlags(SmiNode *smiNode)
{

    switch (smiNode->access) {
    case SMI_ACCESS_UNKNOWN:
	return "---";
    case SMI_ACCESS_NOT_ACCESSIBLE:
	return "---";
    case SMI_ACCESS_NOTIFY:
	return "--n";
    case SMI_ACCESS_READ_ONLY:
	return "r-n";
    case SMI_ACCESS_READ_WRITE:
	return "rwn";
    case SMI_ACCESS_NOT_IMPLEMENTED:
	return "---";
    case SMI_ACCESS_INSTALL:
	return "-i-";
    case SMI_ACCESS_INSTALL_NOTIFY:
	return "-in";
    case SMI_ACCESS_REPORT_ONLY:
	return "--r";
    }

    return "";
}



static char getStatusChar(SmiStatus status)
{
    switch (status) {
    case SMI_STATUS_UNKNOWN:
	return '+';
    case SMI_STATUS_CURRENT:
	return '+';
    case SMI_STATUS_DEPRECATED:
	return 'x';
    case SMI_STATUS_MANDATORY:
        return '+';
    case SMI_STATUS_OPTIONAL:
	return '+';
    case SMI_STATUS_OBSOLETE:
	return 'o';
    }

    return ' ';
}



static char *getTypeName(SmiNode *smiNode)
{
    char *type;
    SmiType *smiType, *parentType;

    smiType = smiGetNodeType(smiNode);

    if (!smiType || smiNode->nodekind == SMI_NODEKIND_TABLE)
	return NULL;
    
    if (smiType->decl == SMI_DECL_IMPLICIT_TYPE) {
	parentType = smiGetParentType(smiType);
	if (!parentType)
	    return NULL;
	smiType = parentType;
    }

    type = xstrdup(smiType->name);
    return type;
}



static int fprintGroup(FILE *f, SmiNode *smiNode, char c, int typelen)
{
    SmiElement *smiElement;
    SmiNode *smiObject;
    SmiModule *smiModule;
    char *type_name;
    int len = 9;

    switch (smiNode->nodekind) {
    case SMI_NODEKIND_GROUP:
	for (smiElement = smiGetFirstElement(smiNode);
	     smiElement;
	     smiElement = smiGetNextElement(smiElement)) {
	    smiObject = smiGetElementNode(smiElement);
	    smiModule = smiGetNodeModule(smiNode);
	    type_name = getTypeName(smiObject);
	    if (typelen) {
		fprintf(f, "  %c%c%s %-*s %s\n",
			getStatusChar(smiObject->status), c,
			getFlags(smiObject),
			typelen, type_name ? type_name : "-",
			smiObject->name);
	    } else {
		if (type_name) {
		    int newlen = strlen(type_name);
		    len = (len < newlen) ? newlen : len;
		}
	    }
	    xfree(type_name);
	}
	break;
    case SMI_NODEKIND_SCALAR:
    case SMI_NODEKIND_COLUMN:
	smiObject = smiNode;
	type_name = getTypeName(smiObject);
	if (typelen) {
	    fprintf(f, "  %c%c%s %-*s %s\n",
		    getStatusChar(smiObject->status), 'r',
		    getFlags(smiObject),
		    typelen, type_name ? type_name : "-",
		    smiObject->name);
	} else {
	    if (type_name) {
		int newlen = strlen(type_name);
		len = len < newlen ? newlen : len;
	    }
	}
	xfree(type_name);
	break;
    default:
	break;
    }

    return len;
}



static int fprintCompliance(FILE *f, SmiNode *smiNode, int typelen)
{
    SmiElement *smiElement;
    SmiOption *smiOption;
    SmiRefinement *smiRefinement;
    int len = 0, newlen;

    for (smiElement = smiGetFirstElement(smiNode);
	 smiElement;
	 smiElement = smiGetNextElement(smiElement)) {
	newlen = fprintGroup(f, smiGetElementNode(smiElement), 'm', typelen);
	len = len < newlen ? newlen : len;
    }

    for(smiOption = smiGetFirstOption(smiNode); smiOption;
	smiOption = smiGetNextOption(smiOption)) {
	newlen = fprintGroup(f, smiGetOptionNode(smiOption), 'c', typelen);
	len = len < newlen ? newlen : len;
    }

    for (smiRefinement = smiGetFirstRefinement(smiNode);
	 smiRefinement;
	 smiRefinement = smiGetNextRefinement(smiRefinement)) {
	newlen = fprintGroup(f, smiGetRefinementNode(smiRefinement), 'r', typelen);
	len = len < newlen ? newlen : len;
    }

    return len;
}



static void fprintCompliances(FILE *f, SmiModule *smiModule)
{
    SmiNode *smiNode;
    int i, len;

    for (i = 0, smiNode = smiGetFirstNode(smiModule, SMI_NODEKIND_COMPLIANCE);
	 smiNode;
	 smiNode = smiGetNextNode(smiNode, SMI_NODEKIND_COMPLIANCE), i++) {
	fprintf(f, "%s%s:\n", i ? "\n" : "", smiNode->name);
	len = fprintCompliance(f, smiNode, 0);
	(void) fprintCompliance(f, smiNode, len);
    }
}



static void
dumpCompliances(int modc, SmiModule **modv, int flags, char *output)
{
    int     i;
    FILE    *f = stdout;
    
    if (output) {
	f = fopen(output, "w");
	if (!f) {
	    fprintf(stderr, "smidump: cannot open %s for writing: ", output);
	    perror(NULL);
	    exit(1);
	}
    }

    for (i = 0; i < modc; i++) {
	if (! (flags & SMIDUMP_FLAG_SILENT)) {
	    fprintf(f, "# %s compliances (generated by smidump "
		    SMI_VERSION_STRING ")\n\n", modv[i]->name);
	}
	fprintCompliances(f, modv[i]);
    }

    if (fflush(f) || ferror(f)) {
	perror("smidump: write error");
	exit(1);
    }

    if (output) {
	fclose(f);
    }
}



void initCompliances()
{
    static SmidumpDriver driver = {
	"compliances",
	dumpCompliances,
	SMI_FLAG_NODESCR,
	SMIDUMP_DRIVER_CANT_UNITE,
	"compliances with all included objects / notifications",
	/* opt, */ NULL,
	NULL
    };
    
    smidumpRegisterDriver(&driver);
}