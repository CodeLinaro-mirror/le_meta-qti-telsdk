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
	DEPENDS:=+libtelux_data +libexecinfo
endef

define Package/telux-LocationTestApp
	SECTION:=telux
	CATEGORY:=QTI-PACKAGES
	TITLE:=telux-LocationTestApp
	MAINTAINER:= Vthuniki
	DEPENDS:=+libtelux_loc
endef

define Package/telux-SwUpdateConsoleApp
	SECTION:=telux-SwUpdateConsoleApp
	CATEGORY:=QTI-PACKAGES
	TITLE:=telux-SwUpdateConsoleApp
	DEPENDS:=+telux-public +libtelux_swupdate +libexecinfo
endef

define Package/telux-SwUpdateApp
	SECTION:=telux-SwUpdateApp
	CATEGORY:=QTI-PACKAGES
	TITLE:=telux-SwUpdateApp
	DEPENDS:=+telux-public +libtelux_swupdate +libexecinfo
endef

define Package/audio-ConsoleApp
	SECTION:=telux
	CATEGORY:=QTI-PACKAGES
	TITLE:=audio-ConsoleApp
	MAINTAINER:=QTI MM Audio
	DEPENDS:=+libexecinfo
endef

define Package/audio-ConsoleApp/Description
	AUDIO-CONSOLEAPP
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

define Package/telux-SwUpdateConsoleApp/Description
        TELUX-SwUpdateConsoleApp
endef

define Package/telux-SwUpdateApp/Description
        TELUX-SwUpdateApp
endef

CMAKE_OPTIONS+= \
	-DTELSDK_TEST_DATA:bool=TRUE \
	-DTELSDK_FEATURE_DATA:bool=TRUE \
        -DBUILD_ALL_SAMPLES:bool=TRUE \
	-DTELSDK_TEST_LOC:bool=TRUE \
	-DTELSDK_FEATURE_SWUPDATE:bool=TRUE

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

define Package/telux-SwUpdateConsoleApp/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/ipkg-install/usr/bin/swupdate_console_app $(1)/usr/bin
endef

define Package/telux-SwUpdateApp/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/ipkg-install/usr/bin/swupdate_app $(1)/usr/bin
endef

ifeq ($(PROFILE),"mbb")
define Package/audio-ConsoleApp/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(CP) $(PKG_BUILD_DIR)/ipkg-install/usr/bin/audio_console_app $(1)/usr/bin/
endef
endif

$(eval $(call BuildPackage,telsdk_console_app))
$(eval $(call BuildPackage,telux-DataApp))
$(eval $(call BuildPackage,telux-LocationTestApp))
$(eval $(call BuildPackage,telux-SwUpdateConsoleApp))
$(eval $(call BuildPackage,telux-SwUpdateApp))
$(eval $(call BuildPackage,audio-ConsoleApp))
