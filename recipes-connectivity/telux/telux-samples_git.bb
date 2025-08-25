SUMMARY = "Telematics SDK Samples"
DESCRIPTION = "Telematics SDK Samples"
LICENSE = "BSD-3-Clause & BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9 \
   file://${WORKDIR}/telux/public/asn1c/LICENSE;md5=ee8bfaaa7d71cf3edb079475e6716d4b"
DEPENDS += "telux telux-lib telux-prop-noship systemd curl canwrapper json-c"
DEPENDS += " ${@bb.utils.contains('MACHINE_FEATURES', 'qti-mvm', 'mvm-dlkm', '', d)} "
# dlt-logging is not expected to run in qti-vm-guest
DEPENDS += " ${@bb.utils.contains('MACHINE_FEATURES', 'dlt-logging', 'dlt-daemon', '', d)} "
DEPENDS += " ${@bb.utils.contains_any('MACHINE_FEATURES', [ 'qti-cv2x', 'qti-wwan-plus-cv2x' ], 'aerolink aerolink-headers v2x-lib', '', d)} "


SRC_URI = "\
    git://github.com/vlm/asn1c;name=asn1c;protocol=https;nobranch=1;tag=94f0b645d401f75b5b1aa8e5440dc2df0f916517;destsuffix=telux/public/asn1c\
    file://telux/public \
    file://telux_power_refd.service \
    "

S = "${WORKDIR}/telux/public/samples"
SYSTEMD_SERVICE:${PN} = "${@bb.utils.contains_any('MACHINE_FEATURES', ['pps', 'qti-location'], 'chrony-sock.service', '', d)}"
SYSTEMD_SERVICE:${PN}:remove += "${@bb.utils.contains_any('MACHINE_FEATURES', 'qti-vm-guest qti-eap', 'chrony-sock.service', '', d)}"

inherit pkgconfig cmake systemd useradd

ITSUSER ?= "its"
ITS_GROUP = "system,radio,diag,locclient,mvm,gpio,spi,qwes"
ITS_ADD_GROUP = "${@bb.utils.contains('MACHINE_FEATURES', 'dlt-logging', ',dlt', '', d)}"
ITS_GROUP:append = "${ITS_ADD_GROUP}"
USERADD_PARAM:${PN} = "${@bb.utils.contains_any('MACHINE_FEATURES', [ 'qti-cv2x', 'qti-wwan-plus-cv2x' ], " \
                       -G ${ITS_GROUP} -u 4024 -U ${ITSUSER}", "", d)}"

EXTRA_OECMAKE = " \
    -DASN1C_PATH=${WORKDIR}/telux/public/asn1c \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '-DWITH_SYSTEMD:BOOL=ON', '', d)} \
    -DAUDIO_ENABLED=ON \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-vm-guest', '-DTELSDK_FEATURE_FOR_SECONDARY_VM=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'external-ap', '-DTELUX_FOR_EXTERNAL_AP=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-eap', '-DTELUX_FOR_EXTERNAL_AP=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-external-ap', '-DTELUX_QTI_EXTERNAL_AP=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-cv2x', '-DMACHINE_HAS_CV2X_ONLY=ON', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'qti-wwan-plus-cv2x', '-DMACHINE_HAS_CV2X=ON', '', d)} \
    ${@bb.utils.contains_any('MACHINE_FEATURES', [ 'qti-cv2x', 'qti-wwan-plus-cv2x' ], '-DWITH_AEROLINK=ON', '', d)} \
    ${@bb.utils.contains_any('MACHINE_FEATURES', ['qti-location','pps'], '-DWITH_LOCATION=ON', '', d)} \
    ${@bb.utils.contains_any('MACHINE_FEATURES', ['qti-vm-host','qti-vm-guest'], '', '-DTELSDK_FEATURE_FOR_PVM_ONLY=ON', d)} \
"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -m 0644 ${WORKDIR}/telux_power_refd.service -D ${D}${systemd_unitdir}/system/telux_power_refd.service
    fi
    if ${@bb.utils.contains_any('MACHINE_FEATURES', 'pps qti-location', 'true', 'false', d)}; then
        if ${@bb.utils.contains_any('MACHINE_FEATURES', 'qti-vm-guest qti-eap', 'false', 'true', d)}; then
            install -m 0644 ${WORKDIR}/telux/public/apps/reference/chrony-sock/config_files/telux_chrony-sock.conf -D ${D}${sysconfdir}/telux_chrony-sock.conf
        fi
    fi
}

FILESPATH =+ "${WORKSPACE}:"
FILES:${PN} += "${systemd_unitdir}"
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so"
