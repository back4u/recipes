# S = "${WORKDIR}"
# ${S} : /home/pilot/yocto/master/poky/build_gidi/tmp/work/corei7-64-poky-linux/gidi/1.0-r0
# ${D} : ${S}/image

SUMMARY = "GIDI application"
LICENSE = "CLOSED"

DEPENDS = " boost opencv dlib"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/src:"

SRC_URI = "file://*.*"

S = "${WORKDIR}"

INCLUDES = "-I${S}/recipe-sysroot/usr/include"

LFLAGS   = "-I${S}/recipe-sysroot/usr/lib"

CXXFLAGS_prepend = "${INCLUDES} "

EXTRA_OEMAKE = "'CC=${CXX}' 'RANLIB=${RANLIB}' 'AR=${AR}' 'LFLAGS=${LFLAGS}' 'CFLAGS=${CXXFLAGS} -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

do_install() {	
	install -d -m 0755 ${D}/home/root/gidi
	install -p -m 0755 ${S}/gidi                        ${D}/home/root/gidi
	install -p -m 0755 ${THISDIR}/${PN}/data/mask/*     ${D}/home/root/gidi
	install -p -m 0755 ${THISDIR}/${PN}/data/template/* ${D}/home/root/gidi
	install -p -m 0755 ${THISDIR}/${PN}/data/train/*    ${D}/home/root/gidi
	install -p -m 0755 ${THISDIR}/${PN}/data/video/*    ${D}/home/root/gidi
}

FILES_${PN} = "/home/root/gidi/*"
INSANE_SKIP_${PN} = "ldflags"

#INSANE_SKIP_${PN} += "installed-vs-shipped"
#TARGET_CC_ARCH += "${LDFLAGS}"
#INSANE_SKIP_${PN}-dev = "ldflags" 
#EXTRA_OEMAKE_append = " 'LDFLAGS=${LDFLAGS}'"
