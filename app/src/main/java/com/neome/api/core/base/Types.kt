// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base

class Types
{
  enum class EnumDeeplinkActionType(val value: String)
  {
    entAdminInvite("entAdminInvite"),
    entHumanLink("entHumanLink"),
    entReportShare("entReportShare"),
    entSpreadsheetEditorShare("entSpreadsheetEditorShare"),
    entSpreadsheetInsertShare("entSpreadsheetInsertShare"),
    entSpreadsheetRowShare("entSpreadsheetRowShare"),
    entUserInvite("entUserInvite"),
    groupInvite("groupInvite"),
    pluginAdminInvite("pluginAdminInvite"),
    signIn("signIn"),
    storeAdminInvite("storeAdminInvite")
  }

  enum class EnumMobileInviteType(val value: String)
  {
    whatsApp("whatsApp"),
    sms("sms")
  }

  enum class EnumTaskStatus(val value: String)
  {
    initial("initial"),
    inProgress("inProgress"),
    failed("failed"),
    completed("completed")
  }

  enum class EnumTimeDuration(val value: String)
  {
    hourly("hourly"),
    daily("daily"),
    weekly("weekly"),
    monthly("monthly")
  }

  enum class EnumTopicType(val value: String)
  {
    agentEnt("agentEnt"),
    analyticEventCount("analyticEventCount"),
    caller("caller"),
    callerAddrBook("callerAddrBook"),
    callerBadgeMap("callerBadgeMap"),
    callerDeviceList("callerDeviceList"),
    callerEnt("callerEnt"),
    callerRecentList("callerRecentList"),
    callerSetting("callerSetting"),
    callerStarMessageList("callerStarMessageList"),
    callerStudioAdmin("callerStudioAdmin"),
    clusterAnalyticEventCount("clusterAnalyticEventCount"),
    entAddrBook("entAddrBook"),
    entAvatarAdmin("entAvatarAdmin"),
    entAvatarUser("entAvatarUser"),
    entSnapshot("entSnapshot"),
    favoriteWorkflowNode("favoriteWorkflowNode"),
    formComment("formComment"),
    formResult("formResult"),
    groupActionList("groupActionList"),
    groupAvatar("groupAvatar"),
    groupInfo("groupInfo"),
    groupTyping("groupTyping"),
    guaranteedRequest("guaranteedRequest"),
    mediaList("mediaList"),
    message("message"),
    messageClearChat("messageClearChat"),
    messageLast("messageLast"),
    messageNew("messageNew"),
    messageProps("messageProps"),
    messageReceiptsChanged("messageReceiptsChanged"),
    pluginApiRequest("pluginApiRequest"),
    spreadsheet("spreadsheet"),
    spreadsheetClear("spreadsheetClear"),
    spreadsheetRef("spreadsheetRef"),
    spreadsheetRowExpiry("spreadsheetRowExpiry"),
    storeItem("storeItem"),
    storeItemAvatar("storeItemAvatar"),
    studioAdminBook("studioAdminBook"),
    studioAdminEditLock("studioAdminEditLock"),
    studioKeychain("studioKeychain"),
    studioEnt("studioEnt"),
    studioEntDeploy("studioEntDeploy"),
    studioPlugin("studioPlugin"),
    studioPluginAvatar("studioPluginAvatar"),
    userAvatar("userAvatar"),
    userCommonGroupList("userCommonGroupList"),
    userLastOnline("userLastOnline"),
    userNotification("userNotification"),
    userTyping("userTyping"),
    workflow("workflow"),
    workflowDebugConfig("workflowDebugConfig")
  }
}