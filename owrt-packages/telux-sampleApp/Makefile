include $(TOPDIR)/rules.mk

PKG_NAME:=telux-sampleApp
PKG_VERSION:=1
PKG_RELEASE:=1
PKG_LICENSE:=BSD-3-Clause & BSD-3-Clause-Clear

LOCAL_SRC:=$(TOPDIR)/src/telux/public

include $(INCLUDE_DIR)/package.mk

define Package/telux-DataApp
	SECTION:=telux-DataApp
	CATEGORY:=QTI-PACKAGES
	TITLE:=telux-DataApp
	DEPENDS:=+dsutils +libqmi-client-helper +qmi +qmi-framework +libtelux_common +libtelux_data  +libtelux_qmi
endef

define Package/telux-DataApp/Description
	TELUX-DataApp
endef

TARGET_CFLAGS += -Og \
	-DTELSDK_FEATURE_CONFIG \
	-DTELSDK_FEATURE_DATA \
	-DTELSDK_FEATURE_MULTI_VLAN_SINGLE_PDN_BINDING \
	-DTELSDK_FEATURE_MULTI_BACKHAUL_SUPPORT \
	-DTELSDK_FEATURE_BACKHAUL_CONNECTIVITY_CONFIG \
	-I$(STAGING_DIR)/usr/include/qmi \
	-I$(STAGING_DIR)/usr/include/qmi_client_helper \
	-I$(STAGING_DIR)/usr/include/dsutils \
	-I$(STAGING_DIR)/usr/include/dsi_netctrl \
	-I$(STAGING_DIR)/usr/include/libtelux_common \
	-I$(STAGING_DIR)/usr/include/libtelux_data \
	-I$(STAGING_DIR)/usr/include/libtelux_qmi \
	-I/usr/include/glib-2.0 \
	-I$(STAGING_DIR)/usr/include/glib-2.0

TARGET_LDFLAGS += \
	-L$(STAGING_DIR)/usr/lib \
	-lqmi \
	-lqmi_client_helper  \
	-ldsutils \
	-ldsi_netctrl \
	-ltelux_common \
	-ltelux_data \
	-ltelux_qmi \

define Build/Prepare
	$(INSTALL_DIR) $(PKG_BUILD_DIR)
	$(INSTALL_DIR) $(PKG_BUILD_DIR)/public
	$(CP) $(LOCAL_SRC)/* $(PKG_BUILD_DIR)/public
	$(INSTALL_DIR) $(PKG_BUILD_DIR)/libs/src/data
endef

MAKE_PATH=public/apps/samples

define Build/InstallDev
	$(INSTALL_DIR) $(STAGING_DIR)
	mkdir -p $(1)/usr/include/telux_DataApp
	$(CP) $(PKG_BUILD_DIR)/public/include/telux/data/DataFactory.hpp $(1)/usr/include/telux_DataApp
endef

define Package/telux-DataApp/install
	$(INSTALL_DIR) $(1)/usr/bin
	$(INSTALL_BIN) $(PKG_BUILD_DIR)/public/apps/samples/bin/DataApp $(1)/usr/bin
endef

$(eval $(call BuildPackage,telux-DataApp))
