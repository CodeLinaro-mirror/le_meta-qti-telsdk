include $(INCLUDE_DIR)/target.mk

QTITELSDK:=

###Add target specific packages
ifeq ($(BOARD),sdx35)
	QTITELSDK+=
else ifeq ($(BOARD),sdx65)
	QTIDATAPROP+=
else ifeq ($(BOARD),sdx85)
    QTITELSDK+= telux-public telsdk_console_app telux-DataApp telux-LocationTestApp telux-SwUpdateConsoleApp telux-SwUpdateApp telux-cellular_connection_security_app telux-wifi_connection_security_app telux-crypto_console_app
endif
