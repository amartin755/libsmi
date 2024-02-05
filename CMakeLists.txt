###############################################################################
cmake_minimum_required (VERSION 3.13)

project (libsmi VERSION 0.5.0
                 DESCRIPTION "A LIBRARY FOR SMI MANAGEMENT INFORMATION"
                 LANGUAGES C)
###############################################################################

set (LIBTOOL_VERSION 2)
set (LIBTOOL_REVISION 27)
set (LIBTOOL_AGE 0)
set (VERSION_STRING "${PROJECT_VERSION}")
set (VERSION_LIBTOOL "${LIBTOOL_VERSION}:${LIBTOOL_REVISION}:${LIBTOOL_AGE}")
set (VERSION "${PROJECT_VERSION}")
set (LIBSMI_MAJOR ${PROJECT_VERSION_MAJOR})
set (LIBSMI_MINOR ${PROJECT_VERSION_MINOR})
set (LIBSMI_PATCHLEVEL ${PROJECT_VERSION_PATCH})


# build options
###############################################################################
set (DEFAULT_ERRORLEVEL 3)
set (MAX_LEX_DEPTH 30)
option (BUILD_STATIC_LIB "Build static library instead of dynamic (shared object or dll)" ON)
option (BACKEND_SMI "enable/disable SMIv1/v2 parser support, default enabled" ON)
option (BACKEND_YANG "enable/disable YANG parser support, default enabled" ON)
option (BACKEND_SMING "enable/disable SMIng parser support, default disabled" OFF)
if (NOT DIR_SEPARATOR)
    if (WIN32)
        set (DIR_SEPARATOR "\\\\")
    else()
        set (DIR_SEPARATOR "/")
    endif()
endif()
if (NOT PATH_SEPARATOR)
    if (WIN32)
        set (PATH_SEPARATOR ";")
    else()
        set (PATH_SEPARATOR ":")
    endif()
endif()
if (NOT PREFIX)
    if (NOT WIN32)
        set (PREFIX "${DIR_SEPARATOR}usr${DIR_SEPARATOR}local")
    else()
        set (PREFIX "c:${DIR_SEPARATOR}smi")
    endif()
endif()
if (NOT DEFAULT_GLOBALCONFIG)
    if (NOT WIN32)
        include (GNUInstallDirs)
        set (DEFAULT_GLOBALCONFIG "${DIR_SEPARATOR}${CMAKE_INSTALL_SYSCONFDIR}${DIR_SEPARATOR}smi.conf")
    else()
        set (DEFAULT_GLOBALCONFIG "${PREFIX}${DIR_SEPARATOR}smi${DIR_SEPARATOR}smi.conf")
    endif()
endif()
if (NOT DEFAULT_USERCONFIG)
    set (DEFAULT_USERCONFIG ".smirc")
endif()
set (MIBDIR "${PREFIX}${DIR_SEPARATOR}share${DIR_SEPARATOR}mibs")
set (PIBDIR "${PREFIX}${DIR_SEPARATOR}share${DIR_SEPARATOR}pibs")
set (YANGDIR "${PREFIX}${DIR_SEPARATOR}share${DIR_SEPARATOR}yang")
if (NOT DEFAULT_SMIPATH)
    set (DEFAULT_MIBPATH  "${MIBDIR}/ietf${PATH_SEPARATOR}${MIBDIR}/iana${PATH_SEPARATOR}${MIBDIR}/irtf${PATH_SEPARATOR}${MIBDIR}/site${PATH_SEPARATOR}${MIBDIR}/jacobs${PATH_SEPARATOR}${MIBDIR}/tubs")
    set (DEFAULT_PIBPATH  "${PIBDIR}${DIR_SEPARATOR}ietf${PATH_SEPARATOR}${PIBDIR}${DIR_SEPARATOR}site${PATH_SEPARATOR}${PIBDIR}${DIR_SEPARATOR}tubs")
    set (DEFAULT_YANGPATH "${YANGDIR}${DIR_SEPARATOR}ietf${PATH_SEPARATOR}${YANGDIR}${DIR_SEPARATOR}iana${PATH_SEPARATOR}${YANGDIR}${DIR_SEPARATOR}site")

    set (DEFAULT_SMIPATH "${DEFAULT_MIBPATH}${PATH_SEPARATOR}${DEFAULT_PIBPATH}${PATH_SEPARATOR}${DEFAULT_YANGPATH}")
endif()

# compiler settings
###############################################################################
if (MSVC)
    # only include minimum windows dependencies
    add_compile_definitions (WIN32_LEAN_AND_MEAN)
    # suppress warnings about unsafe strncpy and friends
    add_compile_definitions (_CRT_SECURE_NO_WARNINGS)
    # disable warning about depracated POSIX symbols
    add_compile_options (/wd4996)

endif()

# check dependencies
###############################################################################
# on windows we download flex and bison first
if (WIN32)
    include (FetchContent)

    # Avoid warning about DOWNLOAD_EXTRACT_TIMESTAMP in CMake 3.24:
    if (CMAKE_VERSION VERSION_GREATER_EQUAL "3.24.0")
        cmake_policy(SET CMP0135 NEW)
    endif()
    FetchContent_Declare (
        flexbison
        URL      https://github.com/lexxmark/winflexbison/releases/download/v2.5.25/win_flex_bison-2.5.25.zip
        URL_HASH SHA256=8d324b62be33604b2c45ad1dd34ab93d722534448f55a16ca7292de32b6ac135
    )
    FetchContent_MakeAvailable (flexbison)
    find_program (BISON_EXECUTABLE NAMES bison win-bison win_bison PATHS "${flexbison_SOURCE_DIR}")
    find_program (FLEX_EXECUTABLE NAMES flex win-flex win_flex PATHS "${flexbison_SOURCE_DIR}")
endif()

find_package (BISON REQUIRED)
find_package (FLEX REQUIRED)

# config
###############################################################################
include (CheckFunctionExists)
check_function_exists (strtoll HAVE_STRTOLL)
check_function_exists (strtoull HAVE_STRTOULL)
check_function_exists (strtoq HAVE_STRTOQ)
check_function_exists (strtouq HAVE_STRTOUQ)
check_function_exists (timegm HAVE_TIMEGM)
if (MSVC)
	set (CMAKE_REQUIRED_LIBRARIES "legacy_stdio_definitions.lib")
endif ()
check_function_exists (vsnprintf HAVE_VSNPRINTF)
check_function_exists (snprintf HAVE_SNPRINTF)
check_function_exists (asprintf HAVE_ASPRINTF)
check_function_exists (asnprintf HAVE_ASNPRINTF)
check_function_exists (vasprintf HAVE_VASPRINTF)
check_function_exists (vasnprintf HAVE_VASNPRINTF)
set (CMAKE_REQUIRED_LIBRARIES "")
include (CheckIncludeFile)
include (CheckIncludeFiles)
check_include_file ("pwd.h" HAVE_PWD_H)
check_include_file ("unistd.h" HAVE_UNISTD_H)
check_include_file ("regex.h" HAVE_REGEX_H)
check_include_file ("stdint.h" HAVE_STDINT_H)
check_include_file ("limits.h" HAVE_LIMITS_H)
check_include_file ("dlfcn.h" HAVE_DLFCN_H)
check_include_file ("inttypes.h" HAVE_INTTYPES_H)
check_include_file ("stdio.h" HAVE_STDIO_H)
check_include_file ("stdlib.h" HAVE_STDLIB_H)
check_include_file ("strings.h" HAVE_STRINGS_H)
check_include_file ("string.h" HAVE_STRING_H)
check_include_file ("sys/stat.h" HAVE_SYS_STAT_H)
check_include_file ("sys/types.h" HAVE_SYS_TYPES_H)
check_include_files("stdlib.h;stdarg.h;string.h;float.h" STDC_HEADERS)

# imitate the strange 64bit logic of configure.ac
include(CheckTypeSize)
check_type_size("long long" SIZEOF_LONG_LONG)
check_type_size("long" SIZEOF_LONG)
if(SIZEOF_LONG_LONG EQUAL "8")
  set(INT64_T "long long")
  set (UINT64_FORMAT "%llu")
  set (INT64_FORMAT "%lld")
elseif(SIZEOF_LONG EQUAL "8")
  set(INT64_T "long")
  set (UINT64_FORMAT "%lu")
  set (UINT64_FORMAT "%ld")
else()
  message(FATAL_ERROR "Can't find suitable 64 bit type")
endif()
message(STATUS "Found 64 bit type: ${INT64_T}")
set (LIBSMI_INT64_MAX 9223372036854775807LL)
set (LIBSMI_INT64_MIN -9223372036854775807LL)
set (LIBSMI_UINT64_MAX 18446744073709551615ULL)
set (UINT64_TYPE "unsigned ${INT64_T}")
set (INT64_TYPE "${INT64_T}")

# windows specific tweaks
if (WIN32)
    if (MSVC)
        add_compile_definitions (strcasecmp=_stricmp)
#        add_compile_definitions (isatty=_isatty)
#        add_compile_definitions (fileno=_fileno)
    endif ()
    if (NOT HAVE_UNISTD_H)
        add_compile_definitions (F_OK=00)
        add_compile_definitions (W_OK=02)
        add_compile_definitions (R_OK=04)
    endif()
    set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)
endif()

configure_file (config.h.cmake.in config.h)
configure_file (lib/smi.h.in smi.h)

# main library target
###############################################################################
if (NOT BUILD_STATIC_LIB)
    add_library (smi SHARED)
else ()
    add_library (smi STATIC)
endif ()
include_directories (${CMAKE_CURRENT_BINARY_DIR})
include_directories (lib)

BISON_TARGET(smiparser lib/parser-smi.y ${CMAKE_CURRENT_BINARY_DIR}/parser-smi.c
    DEFINES_FILE ${CMAKE_CURRENT_BINARY_DIR}/parser-smi.tab.h
    COMPILE_FLAGS "-t -psmi")
BISON_TARGET(smingparser lib/parser-sming.y ${CMAKE_CURRENT_BINARY_DIR}/parser-sming.c 
    DEFINES_FILE ${CMAKE_CURRENT_BINARY_DIR}/parser-sming.tab.h 
    COMPILE_FLAGS "-t -psming")
BISON_TARGET(yangparser lib/parser-yang.y ${CMAKE_CURRENT_BINARY_DIR}/parser-yang.c 
    DEFINES_FILE ${CMAKE_CURRENT_BINARY_DIR}/parser-yang.tab.h 
    COMPILE_FLAGS "-t -pyang")
FLEX_TARGET(smiscanner lib/scanner-smi.l ${CMAKE_CURRENT_BINARY_DIR}/scanner-smi.c
    COMPILE_FLAGS "-Cfe -Psmi")
FLEX_TARGET(smingscanner lib/scanner-sming.l ${CMAKE_CURRENT_BINARY_DIR}/scanner-sming.c
    COMPILE_FLAGS "-Cfe -Psming")
FLEX_TARGET(yangscanner lib/scanner-yang.l ${CMAKE_CURRENT_BINARY_DIR}/scanner-yang.c
    COMPILE_FLAGS "-Cfe -Pyang")
ADD_FLEX_BISON_DEPENDENCY (smiscanner smiparser)

target_sources (smi PRIVATE
    lib/common.c
    lib/error.c
    lib/util.c
    lib/snprintf.c
    lib/smi.c
    lib/smi-data.c
    lib/smi-check.c
    lib/yang.c
    lib/yang-data.c
    lib/yang-check.c
    lib/yang-complex-types.c
    lib/smi2yang.c
    ${BISON_smiparser_OUTPUTS}
    ${BISON_smingparser_OUTPUTS}
    ${BISON_yangparser_OUTPUTS}
    ${FLEX_smiscanner_OUTPUTS}
    ${FLEX_smingscanner_OUTPUTS}
    ${FLEX_yangscanner_OUTPUTS}
)

set_target_properties (smi PROPERTIES PUBLIC_HEADER "${CMAKE_CURRENT_BINARY_DIR}/smi.h;lib/yang.h")
install (TARGETS smi PUBLIC_HEADER DESTINATION include)
