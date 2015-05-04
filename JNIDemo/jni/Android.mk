LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE    := firstjni
LOCAL_SRC_FILES := first_jni.c
include $(BUILD_SHARED_LIBRARY)