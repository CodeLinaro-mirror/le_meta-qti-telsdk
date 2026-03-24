include $(TOPDIR)/rules.mk

PKG_NAME:=telux
PKG_VERSION:=1.0
PKG_RELEASE:=r0
PKG_LICENSE:=BSD-3-Clause-Clear

TELUX_PUBLIC:=$(TOPDIR)/src/telux/public

include $(INCLUDE_DIR)/package.mk

define Package/telux
  SECTION:=telux
  CATEGORY:=QTI-PACKAGES
  TITLE:=Telematics SDK public headers
  BUILDONLY:=1
endef

define Package/telux/description
 Telematics SDK C++ headers exported for building SDK-based applications.
endef

# Override default compile (no compilation needed for headers)
define Build/Compile
endef

### Install headers into the SDK staging area (the ONLY correct place)
define Build/InstallDev
    # Create include directories in the staging destination
    $(INSTALL_DIR) $(1)/usr/include/telux/

    # Copy public headers
    $(CP) $(TELUX_PUBLIC)/include/telux/. \
        $(1)/usr/include/telux/
endef

$(eval $(call BuildPackage,telux))
