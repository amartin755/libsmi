#
# Makefile.am --
#
#      Template to generate test Makefile.in using automake.
#
# Copyright (c) 1999 Frank Strauss, Technical University of Braunschweig.
#
# See the file "COPYING" for information on usage and redistribution
# of this file, and for a DISCLAIMER OF ALL WARRANTIES.
#
# @(#) $Id: Makefile.am,v 1.2 1999/06/07 15:44:07 strauss Exp $
#

TESTMIBS =	SNMPv2-MIB IF-MIB MAU-MIB

TESTS			= smilint.test smidump-1.test smidump-2.test
TESTS_ENVIRONMENT	= SMIPATH=@smipath@ TESTMIBS="$(TESTMIBS)"

#CLEANFILES		= smilint.out smidump-1.out smidump-2.out