include $(INCLUDE_DIR)/target.mk

QTITELSDK:=

###Add target specific packages
ifeq ($(BOARD),sdx35)
	QTITELSDK+=
else ifeq ($(BOARD),sdx65)
	QTIDATAPROP+=
else ifeq ($(BOARD),sdx85)
    QTITELSDK+= telux-public telsdk_console_app telux-DataApp
endif
