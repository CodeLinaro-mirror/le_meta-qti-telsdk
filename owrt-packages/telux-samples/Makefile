include $(TOPDIR)/rules.mk

PKG_NAME:=telux-samples
PKG_VERSION:=1
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause & BSD-3-Clause-Clear

LOCAL_SRC:=$(TOPDIR)/src/telux/public/apps/
PKG_BUILD_DIR:=$(BUILD_DIR)/telux-public-$(PKG_VERSION)/public/apps/

CMAKE_INSTALL:=1

include $(INCLUDE_DIR)/package.mk
include $(INCLUDE_DIR)/cmake.mk

define Package/telsdk_console_app
	SECTION:=telux
	CATEGORY:=QTI-PACKAGES
	TITLE:=telsdk_console_app
	DEPENDS:=+libtelux_data +libexecinfo +telux-public
endef

define Package/telux-DataApp
	SECTION:=telux-DataApp
	CATEGORY:=QTI-PACKAGES
	TITLE:=telux-DataApp
	DEPENDS:=+dsutils +libqmi-client-helper +qmi +qmi-framework +libtelux_common +libtelux_data  +libtelux_qmi +telux-public +libexecinfo
endef

define Package/telux-LocationTestApp
	SECTION:=telux
	CATEGORY:=QTI-PACKAGES
	TITLE:=telux-LocationTestApp
	MAINTAINER:= Vthuniki
	DEPENDS:=+libtelux_loc
endef

define Package/telsdk_console_app/Description
	TELSDK_CONSOLE_APP
endef

define Package/telux-DataApp/Description
	TELUX-DataApp
endef

define Package/telux-LocationTestApp/Description
	telux-LocationTestApp
endef

CMAKE_OPTIONS+= \
	-DTELSDK_TEST_DATA:bool=TRUE \
	-DTELSDK_FEATURE_DATA:bool=TRUE \
        -DBUILD_ALL_SAMPLES:bool=TRUE \
	-DTELSDK_TEST_LOC:bool=TRUE \

TARGET_CFLAGS += -Og \
	-D__NEED_ino_t \
	-I$(STAGING_DIR)/usr/include/telux \

TARGET_LDFLAGS += \
	-L$(STAGING_DIR)/usr/lib \
	-lexecinfo

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Package/telsdk_console_app/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(CP) $(PKG_BUILD_DIR)/ipkg-install/usr/bin/telsdk_console_app $(1)/usr/bin/
endef

define Package/telux-DataApp/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/samples/data/data_app/data_app $(1)/usr/bin
endef

define Package/telux-LocationTestApp/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(CP) $(PKG_BUILD_DIR)/ipkg-install/usr/bin/location_test_app $(1)/usr/bin/
endef

$(eval $(call BuildPackage,telsdk_console_app))
$(eval $(call BuildPackage,telux-DataApp))
$(eval $(call BuildPackage,telux-LocationTestApp))
