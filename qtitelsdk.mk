include $(INCLUDE_DIR)/target.mk

QTITELSDK:=

###Add target specific packages
ifeq ($(BOARD),sdx35)
    QTITELSDK+= telux
    QTITELSDK+= telux-samples
else ifeq ($(BOARD),sdx65)
    QTITELSDK+=
else ifeq ($(BOARD),sdx85)
    QTITELSDK+=
endif