inherit pkgconfig cmake

SUMMARY = "Telematics SDK stub library"
DESCRIPTION = "Stub library that can be used to compile telematics applications."

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0 \
          file://${COREBASE}/meta/files/common-licenses/\
BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PACKAGE_ARCH ?= "${MACHINE_ARCH}"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://telux/public/bin/"
S = "${WORKDIR}/telux/public/bin"

FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"
