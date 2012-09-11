# (c) Copyright 2012  Hewlett-Packard Development Company, L.P.

DESCRIPTION = "A base class for browser plugins loaded by webOS."
LICENSE = "Apache-2.0"
SECTION = "Linux/System"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "glib-2.0 npapi-headers"
RDEPENDS = ""

inherit autotools 

SRC_URI = "${ISIS-PROJECT_GIT_REPO}/AdapterBase;tag=${WEBOS_GIT_TAG};protocol=git"
S = "${WORKDIR}/git"

ALLOW_EMPTY_${PN} = "1"

do_configure() {
	rm -f ${STAGING_INCDIR}/AdapterBase.h
	rm -f ${STAGING_LIBDIR}/AdapterBase.a
}

do_compile() {
	LUNA_STAGING="." make
}

do_install() {
	install -m 444 AdapterBase.h ${STAGING_INCDIR}
	install -m 444 AdapterBase.a ${STAGING_LIBDIR}
}
do_makeclean() {
	rm -f ${STAGING_INCDIR}/AdapterBase.h
	rm -f ${STAGING_LIBDIR}/AdapterBase.a
}

