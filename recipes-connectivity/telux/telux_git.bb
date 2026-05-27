SUMMARY = "Telematics SDK headers"
DESCRIPTION = "Telematics SDK headers"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"
SRCREV = "${AUTOREV}"

SRC_URI = "file://telux/public/include"

S = "${UNPACKDIR}/telux/public/include"

inherit pkgconfig cmake

PACKAGES = "${PN}"

RDEPENDS:${PN} += "glib-2.0"

FILESPATH =+ "${WORKSPACE}:"
FILES:${PN} += "/usr/include/*"

ALLOW_EMPTY:${PN} = "1"
