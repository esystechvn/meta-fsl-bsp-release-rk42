# Copyright (C) 2013-2016 Freescale Semiconductor

DESCRIPTION = "U-Boot provided by Freescale with focus on  i.MX reference boards."
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "rk42-custom-uboot-imx"
UBOOT_SRC ?= "https://github.com/esystechvn/esys-6ull-boot-imx.git;protocol=https"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "846cc26ea1c103062ad6aabdbd00b308fc839c02"
SRC_URI[md5sum] = "b607bc1d4a317a1a3ae273591796480f"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

SRC_URI += "file://0001-MLK-13602-1-mx6-Add-i.MX6ULL-fused-modules-checking-.patch \
            file://0002-MLK-13602-2-epdc-Add-disable-fuse-checking.patch \
            file://0003-MLK-13602-3-mx6ullevk-arm2-Enable-module-fuse-checki.patch \
"

LOCALVERSION ?= "-${SRCBRANCH}"
LOCALVERSION = "-imx_v2016.03_4.1.15_2.0.3"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"
