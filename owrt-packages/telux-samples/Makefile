########################################
#            Metadata section          #
########################################
include $(TOPDIR)/rules.mk

PKG_NAME:=telux-samples
PKG_VERSION:=1.0
PKG_RELEASE:=r0
PKG_LICENSE:=BSD-3-Clause-Clear
PKG_BUILD_DEPENDS:=telux

LOCAL_SRC:=$(TOPDIR)/src/telux/public/apps

CMAKE_INSTALL:=1

export PKG_CONFIG_PATH:=$(STAGING_DIR)/usr/lib/pkgconfig

include $(INCLUDE_DIR)/package.mk
include $(INCLUDE_DIR)/cmake.mk

########################################
#            Package blocks            #
########################################

define Package/telux-samples
  SECTION:=telux
  CATEGORY:=QTI-PACKAGES
  TITLE:=Telematics SDK sample and test applications
  DEPENDS:=+telux-lib +libexecinfo
endef

define Package/telux-samples/description
  Telsdk sample and test applications.
endef

########################################
#        Build system configuration    #
########################################

# Set sysroot so that =/usr/include paths work
TARGET_CFLAGS += --sysroot=$(STAGING_DIR)
TARGET_CXXFLAGS += --sysroot=$(STAGING_DIR)

CMAKE_OPTIONS += \
    -DTELSDK_OWRT_SUPPORT=ON \
    -DTELSDK_FEATURE_SATCOM=ON \
    -DCMAKE_PREFIX_PATH=$(STAGING_DIR)/usr

########################################
#          Source preparation          #
########################################

define Build/Prepare
	$(call Build/Prepare/Default)
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

########################################
#       Runtime install per app        #
########################################

define Package/telux-samples/install
	$(INSTALL_DIR) $(1)/usr/bin
	# Install all test apps built by CMake
	$(CP) $(PKG_INSTALL_DIR)/usr/bin/. $(1)/usr/bin/
endef

########################################
#        Register build targets        #
########################################

$(eval $(call BuildPackage,telux-samples))
