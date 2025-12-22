// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base

class Types {
    enum class EnumGroupPatchPropName {
        name,
        about,
        mediaIdAvatar,
        settings
    }

    enum class EnumMessageType {
        audio,
        camera,
        document,
        spreadsheetRow,
        spreadsheetRowDeleted,
        group,
        groupAboutChange,
        groupAvatarChange,
        groupCreate,
        groupExit,
        groupJoinWithInvite,
        groupMemberAdd,
        groupMemberRemove,
        groupNameChange,
        image,
        linkText,
        location,
        messageDeleted,
        report,
        spreadsheetPartition,
        text,
        user,
        video,
        voice
    }

    enum class EnumReceiptStatus {
        error,
        singleTick,
        doubleTick,
        blueTick
    }
}
