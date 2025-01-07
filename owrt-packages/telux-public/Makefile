include $(TOPDIR)/rules.mk

PKG_NAME:=telux-public
PKG_VERSION:=1
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause & BSD-3-Clause-Clear

TELUX_PUBLIC:=$(TOPDIR)/src/telux/public

include $(INCLUDE_DIR)/package.mk

define Package/telux-public
    SECTION:=telux_public
    CATEGORY:=QTI-PACKAGES
    TITLE:=telux-public
endef

define Package/telux-public/Description
    TELUX-PUBLIC
endef

define Build/Prepare
	$(INSTALL_DIR) $(PKG_BUILD_DIR)/public
	$(CP) $(TELUX_PUBLIC)/* $(PKG_BUILD_DIR)/public
	$(CP) $(TELUX_PUBLIC)/include/telux/common/*.hpp $(STAGING_DIR)/usr/include/telux
endef

define Build/Configure
	@true
endef

define Build/Compile
	@true
endef

define Build/InstallDev
	@true
endef

define Package/telux-public/install
	$(INSTALL_DIR) $(PKG_BUILD_DIR)/public
	$(CP) $(TELUX_PUBLIC)/* $(PKG_BUILD_DIR)/public
	$(CP) $(TELUX_PUBLIC)/include/telux/common/*.hpp $(STAGING_DIR)/usr/include/telux
endef

$(eval $(call BuildPackage,$(PKG_NAME)))
