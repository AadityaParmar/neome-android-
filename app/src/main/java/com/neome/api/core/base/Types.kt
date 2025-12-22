// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base

class Types {
    enum class EnumDeeplinkActionType {
        entAdminInvite,
        entHumanLink,
        entReportShare,
        entSpreadsheetEditorShare,
        entSpreadsheetInsertShare,
        entSpreadsheetRowShare,
        entUserInvite,
        groupInvite,
        pluginAdminInvite,
        signIn,
        storeAdminInvite
    }

    enum class EnumMobileInviteType {
        whatsApp,
        sms
    }

    enum class EnumTaskStatus {
        initial,
        inProgress,
        failed,
        completed
    }

    enum class EnumTimeDuration {
        hourly,
        daily,
        weekly,
        monthly
    }

    enum class EnumTopicType {
        agentEnt,
        analyticEventCount,
        caller,
        callerAddrBook,
        callerBadgeMap,
        callerDeviceList,
        callerEnt,
        callerRecentList,
        callerSetting,
        callerStarMessageList,
        callerStudioAdmin,
        clusterAnalyticEventCount,
        entAddrBook,
        entAvatarAdmin,
        entAvatarUser,
        entSnapshot,
        favoriteWorkflowNode,
        formComment,
        formResult,
        groupActionList,
        groupAvatar,
        groupInfo,
        groupTyping,
        guaranteedRequest,
        mediaList,
        message,
        messageClearChat,
        messageLast,
        messageNew,
        messageProps,
        messageReceiptsChanged,
        pluginApiRequest,
        spreadsheet,
        spreadsheetClear,
        spreadsheetRef,
        spreadsheetRowExpiry,
        storeItem,
        storeItemAvatar,
        studioAdminBook,
        studioAdminEditLock,
        studioKeychain,
        studioEnt,
        studioEntDeploy,
        studioPlugin,
        studioPluginAvatar,
        userAvatar,
        userCommonGroupList,
        userLastOnline,
        userNotification,
        userTyping,
        workflow,
        workflowDebugConfig
    }
}
