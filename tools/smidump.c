/*
 * smidump.c --
 *
 *      Dump a MIB module conforming to a given format.
 *
 * Copyright (c) 1999 Frank Strauss, Technical University of Braunschweig.
 * Copyright (c) 1999 J. Schoenwaelder, Technical University of Braunschweig.
 *
 * See the file "COPYING" for information on usage and redistribution
 * of this file, and for a DISCLAIMER OF ALL WARRANTIES.
 *
 * @(#) $Id: smidump.c,v 1.49 2000/11/09 22:29:54 strauss Exp $
 */

#include <config.h>

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#ifdef HAVE_UNISTD_H
#include <unistd.h>
#endif
#ifdef HAVE_GETOPT_H
#include <getopt.h>
#endif
#ifdef HAVE_WIN_H
#include "win.h"
#endif

#include "smi.h"
#include "shhopt.h"
#include "smidump.h"



static void usage();
static void version();
static void config(char *filename);
static void level(int lev);
static void silent();
static void preload(char *module);
static void unified();
static void format(char *form);


static int flags;
static SmidumpDriver *driver;
static SmidumpDriver *firstDriver;
static SmidumpDriver *lastDriver;
static SmidumpDriver *defaultDriver;
static char *output;

static int opts;
static optStruct *opt;
static optStruct genericOpt[] = {
    /* short long              type        var/func       special       */
    { 'h', "help",           OPT_FLAG,   usage,         OPT_CALLFUNC },
    { 'V', "version",        OPT_FLAG,   version,       OPT_CALLFUNC },
    { 'c', "config",         OPT_STRING, config,        OPT_CALLFUNC },
    { 'l', "level",          OPT_INT,    level,         OPT_CALLFUNC },
    { 's', "silent",         OPT_FLAG,   silent,        OPT_CALLFUNC },
    { 'p', "preload",        OPT_STRING, preload,       OPT_CALLFUNC },
    { 'l', "level",          OPT_INT,    level,         OPT_CALLFUNC },
    { 'u', "unified",        OPT_FLAG,   unified,       OPT_CALLFUNC },
    { 'f', "format",         OPT_STRING, format,        OPT_CALLFUNC },
    { 'o', "output",         OPT_STRING, &output,       0            },
    { 0, 0, OPT_END, 0, 0 }  /* no more options */
};



void *xmalloc(size_t size)
{
    char *m = malloc(size);
    if (! m) {
	fprintf(stderr, "smidump: malloc failed - running out of memory\n");
	exit(1);
    }
    return m;
}



void *xrealloc(void *ptr, size_t size)
{
    char *m = realloc(ptr, size);
    if (! m) {
	fprintf(stderr, "smidump: realloc failed - running out of memory\n");
	exit(1);
    }
    return m;
}



char *xstrdup(const char *s)
{
    char *m = strdup(s);
    if (! m) {
	fprintf(stderr, "smidump: strdup failed - running out of memory\n");
	exit(1);
    }
    return m;
}



void xfree(void *ptr)
{
    free(ptr);
}



void smidumpRegisterDriver(SmidumpDriver *driver)
{
    int i;
    
    if (!firstDriver) {
	firstDriver = driver;
	lastDriver = driver;
    } else {
	lastDriver->next = driver;
	lastDriver = driver;
    }

    for (i = 0; driver->opt && driver->opt[i].type != OPT_END; i++) {
	opt = xrealloc(opt, (opts+1) * sizeof(optStruct));
	memcpy(&opt[opts], &opt[opts-1], sizeof(optStruct));
	opt[opts-1].shortName = 0;
	opt[opts-1].longName  = xmalloc(strlen(driver->name) +
				 strlen(driver->opt[i].name) + 2);
	sprintf(opt[opts-1].longName, "%s-%s",
		driver->name, driver->opt[i].name);
	opt[opts-1].type      = driver->opt[i].type;
	opt[opts-1].arg       = driver->opt[i].arg;
	opt[opts-1].flags     = driver->opt[i].flags;
	opts++;
    }
}



static void formats()
{
    SmidumpDriver *driver = firstDriver;
    
    for (driver = firstDriver; driver; driver = driver->next) {
	fprintf(stderr, "  %-14s: %s\n", driver->name,
 		driver->descr ? driver->descr : "...");
    }
}



static void usage()
{
    int i;
    SmidumpDriver *driver;
    
    fprintf(stderr,
	    "Usage: smidump [options] [module or path ...]\n"
	    "  -V, --version        show version and license information\n"
	    "  -h, --help           show usage information\n"
	    "  -s, --silent         do not generate any comments\n"
	    "  -c, --config=file    load a specific configuration file\n"
	    "  -p, --preload=module preload <module>\n"
	    "  -l, --level=level    set maximum level of errors and warnings\n"
	    "  -f, --format=format  use <format> when dumping (default %s)\n"
	    "  -o, --output=name    use <name> when creating names for output files\n"
	    "  -u, --unified        print a single unified output of all modules\n\n",
	    defaultDriver ? defaultDriver->name : "none");

    fprintf(stderr, "Supported formats are:\n");
    formats();

    fprintf(stderr, "\nFormat driver specific options are:\n");
    for (driver = firstDriver; driver; driver = driver->next) {
	for (i = 0; driver->opt && driver->opt[i].type != OPT_END; i++) {
	    fprintf(stderr, "  --%s-%-*s  %s\n",
		    driver->name, 24 - strlen(driver->name),
		    driver->opt[i].name,
		    driver->opt[i].descr ? driver->opt[i].descr : "...");
	}
    }
}



static void version() { printf("smidump " SMI_VERSION_STRING "\n"); }
static void config(char *filename) { smiReadConfig(filename, "smiquery"); }
static void level(int lev) { smiSetErrorLevel(lev); }
static void silent() { flags |= SMIDUMP_FLAG_SILENT; }
static void preload(char *module) { smiLoadModule(module); }
static void unified() { flags |= SMIDUMP_FLAG_UNITE; }

static void format(char *form)
{
    for (driver = firstDriver; driver; driver = driver->next) {
	if (strcasecmp(driver->name, form) == 0) {
	    break;
	}
    }
    if (!driver) {
	fprintf(stderr, "smidump: invalid dump format `%s'"
		" - supported formats are:\n", form);
	formats();
	exit(1);
    }
}



int main(int argc, char *argv[])
{
    char c;
    char *modulename;
    SmiModule *smiModule;
    int smiflags, i;
    SmiModule **modv = NULL;
    int modc = 0;

    output = NULL;
    firstDriver = lastDriver = defaultDriver = NULL;

    opts = sizeof(genericOpt) / sizeof(optStruct);
    opt = xmalloc(sizeof(genericOpt));
    memcpy(opt, genericOpt, sizeof(genericOpt));

    init_cm();
    init_corba();
#if 0
    init_fig();
#endif
    init_identifiers();
    init_imports();
    init_jax();
    init_metrics();
    init_mosy();
    init_netsnmp();
    init_python();
    init_sming();                defaultDriver = lastDriver;
    init_smi();
#if 0
    init_sql();
#endif
    init_tree();
    init_types();
    init_xml();
    
    for (i = 1; i < argc; i++)
	if ((strstr(argv[i], "-c") == argv[i]) ||
	    (strstr(argv[i], "--config") == argv[i])) break;
    if (i == argc) 
	smiInit("smidump");
    else
	smiInit(NULL);

    flags = 0;
    driver = defaultDriver;

    optParseOptions(&argc, argv, opt, 0);

    if (!driver) {
	fprintf(stderr, "smidump: no dump formats registered\n");
	exit(1);
    }
    
    smiflags = smiGetFlags();
    smiflags |= SMI_FLAG_ERRORS;
    smiflags |= driver->smiflags;
    smiSetFlags(smiflags);

    if (flags & SMIDUMP_FLAG_UNITE && driver->ignflags & SMIDUMP_DRIVER_CANT_UNITE) {
	fprintf(stderr, "smidump: %s format does not support united output:"
		" ignoring -u\n", driver->name);
	flags = (flags & ~SMIDUMP_FLAG_UNITE);
    }

    if (output && driver->ignflags & SMIDUMP_DRIVER_CANT_OUTPUT) {
	fprintf(stderr, "smidump: %s format does not support output option:"
		" ignoring -o %s\n", driver->name, output);
	output = NULL;
    }

    modv = (SmiModule **) xmalloc((argc - optind) * sizeof(SmiModule *));
    modc = 0;
    
    while (optind < argc) {
	modulename = smiLoadModule(argv[optind]);
	smiModule = modulename ? smiGetModule(modulename) : NULL;
	if (smiModule) {
	    if ((smiModule->conformance) && (smiModule->conformance < 3)) {
		if (! (flags & SMIDUMP_FLAG_SILENT)) {
		    fprintf(stderr,
			    "smidump: module `%s' contains errors, "
			    "expect flawed output\n",
			    argv[optind]);
		}
	    }
	    modv[modc++] = smiModule;
	} else {
	    fprintf(stderr, "smidump: cannot locate module `%s'\n",
		    argv[optind]);
	}
	optind++;
    }

    (driver->func)(modc, modv, flags, output);

    smiExit();

    if (modv) xfree(modv);
    
    return 0;
}
