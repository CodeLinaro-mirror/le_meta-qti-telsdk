inherit pkgconfig cmake systemd

SUMMARY = "Telematics SDK Samples"
DESCRIPTION = "Telematics SDK Samples"

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0 \
          file://${COREBASE}/meta/files/common-licenses/\
BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PACKAGE_ARCH ?= "${MACHINE_ARCH}"

FILESPATH =+ "${WORKSPACE}:"
SRC_URI = "file://telux/public/"
S = "${WORKDIR}/telux/public/samples/"

EXTRA_OECMAKE += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '-DWITH_SYSTEMD:BOOL=ON', '', d)}"
EXTRA_OECMAKE += "-DMACHINE_HAS_CV2X=OFF"
EXTRA_OECMAKE += "-DTELSDK_FEATURE_LOC=OFF"
EXTRA_OECMAKE += "-DTELSDK_FEATURE_POWER=OFF"

#SYSTEMD_SERVICE_${PN} = "chrony-sock.service"

SRCREV = "${AUTOREV}"

DEPENDS += "telux telux-lib systemd"
