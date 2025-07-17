SUMMARY = "QTI package group for Telsdk modules"
LICENSE = "BSD-3-Clause-Clear"

inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = ' \
    packagegroup-qti-telsdk \
    '

# telsdk packages which are common across various machines
RDEPENDS_${PN} += ' \
    telux-samples \
    '
