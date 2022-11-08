SUMMARY = "Telematics SDK Samples"
DESCRIPTION = "Telematics SDK Samples"
LICENSE = "BSD-3-Clause & BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
   file://${WORKDIR}/telux/public/asn1c/LICENSE;md5=ee8bfaaa7d71cf3edb079475e6716d4b"
DEPENDS += "telux telux-lib systemd curl"

SRC_URI = "\
    git://github.com/vlm/asn1c;name=asn1c;protocol=https;nobranch=1;tag=94f0b645d401f75b5b1aa8e5440dc2df0f916517;destsuffix=telux/public/asn1c\
    file://telux/public \
    file://telux_power_refd.service \
    "

S = "${WORKDIR}/telux/public/samples"
SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains_any('MACHINE_FEATURES', ['pps', 'qti-location'], 'chrony-sock.service', '', d)}"

inherit pkgconfig cmake systemd

EXTRA_OECMAKE = " \
    -DASN1C_PATH=${WORKDIR}/telux/public/asn1c \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '-DWITH_SYSTEMD:BOOL=ON', '', d)} \
    -DAUDIO_ENABLED=ON \
    ${@bb.utils.contains('MACHINE_FEATURES', 'external-ap', '-DTELUX_FOR_EXTERNAL_AP=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-external-ap', '-DTELUX_QTI_EXTERNAL_AP=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-external-ap', '-DWITH_AEROLINK=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-cv2x', '-DMACHINE_HAS_CV2X_ONLY=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-wwan-plus-cv2x', '-DMACHINE_HAS_CV2X=ON', '', d)} \
    ${@bb.utils.contains_any('MACHINE_FEATURES', ['qti-location','pps'], '-DWITH_LOCATION=ON', '', d)} \
"

do_install_append() {
    install -m 0644 ${WORKDIR}/telux/public/apps/tests/telsdk_console_app/config_files/telsdk_app.conf -D ${D}${sysconfdir}/telsdk_app.conf
    install -m 0644 ${WORKDIR}/telux_power_refd.service -D ${D}${systemd_unitdir}/system/telux_power_refd.service
}

FILESPATH =+ "${WORKSPACE}:"
FILES_${PN} += "${systemd_unitdir}"
