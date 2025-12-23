// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base

class Types
{
  enum class EnumGroupPatchPropName(val value: String)
  {
    name_("name"),
    about("about"),
    mediaIdAvatar("mediaIdAvatar"),
    settings("settings")
  }

  enum class EnumMessageType(val value: String)
  {
    audio("audio"),
    camera("camera"),
    document("document"),
    spreadsheetRow("spreadsheetRow"),
    spreadsheetRowDeleted("spreadsheetRowDeleted"),
    group("group"),
    groupAboutChange("groupAboutChange"),
    groupAvatarChange("groupAvatarChange"),
    groupCreate("groupCreate"),
    groupExit("groupExit"),
    groupJoinWithInvite("groupJoinWithInvite"),
    groupMemberAdd("groupMemberAdd"),
    groupMemberRemove("groupMemberRemove"),
    groupNameChange("groupNameChange"),
    image("image"),
    linkText("linkText"),
    location("location"),
    messageDeleted("messageDeleted"),
    report("report"),
    spreadsheetPartition("spreadsheetPartition"),
    text("text"),
    user("user"),
    video("video"),
    voice("voice")
  }

  enum class EnumReceiptStatus(val value: String)
  {
    error("error"),
    singleTick("singleTick"),
    doubleTick("doubleTick"),
    blueTick("blueTick")
  }
}