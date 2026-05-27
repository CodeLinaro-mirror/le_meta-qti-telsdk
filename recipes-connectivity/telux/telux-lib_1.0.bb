SUMMARY = "Telematics SDK stub library"
DESCRIPTION = "Stub library that can be used to compile telematics applications."
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "file://telux/public/bin/"

S = "${UNPACKDIR}/telux/public/bin"

inherit pkgconfig cmake

FILESPATH =+ "${WORKSPACE}:"
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so"
