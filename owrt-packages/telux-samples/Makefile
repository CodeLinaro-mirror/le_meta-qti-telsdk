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
	DEPENDS:=+libtelux_common +libtelux_data +libtelux_qmi +libexecinfo +telux-public
endef

define Package/telsdk_console_app/Description
	TELSDK_CONSOLE_APP
endef

CMAKE_OPTIONS+= \
	-DTELSDK_TEST_DATA:bool=TRUE \
	-DTELSDK_FEATURE_DATA:bool=TRUE \

TARGET_CFLAGS += -Og \
	-D__NEED_ino_t \
	-I$(STAGING_DIR)/usr/include/telux \

TARGET_LDFLAGS += \
	-L$(STAGING_DIR)/usr/lib \
	-ltelux_common \
	-ltelux_data \
	-ltelux_qmi \
	-lexecinfo

define Build/Prepare
	mkdir -p $(PKG_BUILD_DIR)
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/
endef

define Package/telsdk_console_app/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(CP) $(PKG_BUILD_DIR)/ipkg-install/usr/bin/telsdk_console_app $(1)/usr/bin/
endef

$(eval $(call BuildPackage,telsdk_console_app))