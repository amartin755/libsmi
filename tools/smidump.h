/*
 * smidump.h --
 *
 *      This header contains the entry points into the modules
 *	which dump MIB modules in various output format.
 *
 * Copyright (c) 1999 Frank Strauss, Technical University of Braunschweig.
 * Copyright (c) 1999 J. Schoenwaelder, Technical University of Braunschweig.
 *
 * See the file "COPYING" for information on usage and redistribution
 * of this file, and for a DISCLAIMER OF ALL WARRANTIES.
 *
 * @(#) $Id: smidump.h,v 1.10 2000/05/02 12:57:17 strauss Exp $
 */

#ifndef _SMIDUMP_H
#define _SMIDUMP_H


/*
 * The flags that can be passed to output drivers.
 */

#define SMIDUMP_FLAG_SILENT	0x01
#define SMIDUMP_FLAG_UNITE	0x02
#define SMIDUMP_FLAG_CURRENT	0x04
#define SMIDUMP_FLAG_DEPRECATED	0x08
#define SMIDUMP_FLAG_OBSOLETE	0x08
#define SMIDUMP_FLAG_COMPACT	0x10

/*
 * The output drivers that currently exist for smidump.
 */

extern int dumpSmiV1(char *modulename, int flags);
extern int dumpSmiV2(char *modulename, int flags);
extern int dumpSming(char *modulename, int flags);

extern int dumpImports(char *modulename, int flags);
extern int dumpTypes(char *modulename, int flags);
extern int dumpTree(char *modulename, int flags);

extern int dumpMosy(char *modulename, int flags);

extern int dumpCorbaIdl(char *modulename, int flags);
extern int dumpCorbaOid(char *modulename, int flags);

extern int dumpSql(char *modulename, int flags);

extern int dumpUcdH(char *modulename, int flags);
extern int dumpUcdC(char *modulename, int flags);

extern int dumpJax(char *modulename, int flags);

extern int dumpXml(char *modulename, int flags);

extern int dumpMetrics(char *modulename, int flags);

extern int dumpFigTree(char *modulename, int flags);
extern int dumpFigUml(char *modulename, int flags);

extern int dumpCMDia(char *modulename, int flags);
extern int dumpCMXplain(char *modulename, int flags);

/*
 * The functions are wrappers around the malloc functions
 * that handle any memory allocation errors.
 */

extern void *xmalloc(size_t size);
extern void *xrealloc(void *ptr, size_t size);
extern char *xstrdup(const char *s);
extern void xfree(void *ptr);


#endif /* _SMIDUMP_H */

