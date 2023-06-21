inherit pkgconfig cmake

SUMMARY = "Telematics SDK headers"
DESCRIPTION = "Telematics SDK headers"

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0 \
          file://${COREBASE}/meta/files/common-licenses/\
BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PACKAGE_ARCH ?= "${MACHINE_ARCH}"

RDEPENDS_${PN} += "glib-2.0"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://telux/public/include/"
S = "${WORKDIR}/telux/public/include"

SRCREV = "${AUTOREV}"

ALLOW_EMPTY_${PN} = "1"
PACKAGES = "${PN}"
FILES_${PN} += "/usr/include/*"
