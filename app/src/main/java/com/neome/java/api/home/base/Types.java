// neome.ai API - do not change
//

package com.neome.java.api.home.base;

@SuppressWarnings({
  "unused",
  "ClassTooDeepInInheritanceTree"
})
public class Types
{
  public enum EnumGroupPatchPropName
  {
    name,
    about,
    mediaIdAvatar,
    settings
  }

  public enum EnumMessageType
  {
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

  public enum EnumReceiptStatus
  {
    error,
    singleTick,
    doubleTick,
    blueTick
  }
}
