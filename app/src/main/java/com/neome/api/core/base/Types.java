// neome.ai API - do not change
//

package com.neome.api.core.base;

@SuppressWarnings({
  "unused",
  "ClassTooDeepInInheritanceTree"
})
public class Types
{
  public enum EnumDeeplinkActionType
  {
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

  public enum EnumMobileInviteType
  {
    whatsApp,
    sms
  }

  public enum EnumTaskStatus
  {
    initial,
    inProgress,
    failed,
    completed
  }

  public enum EnumTimeDuration
  {
    hourly,
    daily,
    weekly,
    monthly
  }

  public enum EnumTopicType
  {
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