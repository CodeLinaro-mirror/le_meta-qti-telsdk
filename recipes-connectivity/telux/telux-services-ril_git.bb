SUMMARY = "Telephony service for QTI's Modem"
DESCRIPTION = "Telephony service for QTI's Modem"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"
DEPENDS += "glib-2.0 nanopb protobuf-native python3-protobuf-native python3-six-native"

SRC_URI = "file://telux/services/ril"

S = "${WORKDIR}/telux/services/ril"

inherit pkgconfig cmake python3native systemd

EXTRA_OECMAKE = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-external-ap', '-DRIL_FOR_EXTERNAL_AP=ON', '', d)} \
"

FILESPATH =+ "${WORKSPACE}:"
