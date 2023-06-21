inherit pkgconfig cmake python3native

SUMMARY = "Telephony service for QTI's Modem"
DESCRIPTION = "Telephony service for QTI's Modem"

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0 \
          file://${COREBASE}/meta/files/common-licenses/\
BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PACKAGE_ARCH ?= "${MACHINE_ARCH}"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://telux/services/ril/"
S = "${WORKDIR}/telux/services/ril"

EXTRA_OECMAKE += "${@bb.utils.contains('MACHINE_FEATURES', 'external-ap', '-DRIL_FOR_EXTERNAL_AP=ON', '', d)}"

DEPENDS += "glib-2.0 nanopb python3-protobuf-native"
