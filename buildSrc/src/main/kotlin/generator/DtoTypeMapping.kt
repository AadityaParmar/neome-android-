package generator

val dtoEntActionMapping = mapOf<String, String>(
    "DtoEntActionExecuteWorkflow" to "executeCallable",
    "DtoEntActionReport" to "report",
    "DtoEntActionRowInsert" to "rowInsert",
    "DtoEntActionRowUpdate" to "rowUpdate",
    "DtoEntActionSpreadsheetEditor" to "spreadsheetEditor",
    "DtoEntActionSpreadsheetHistory" to "spreadsheetHistory",
    "DtoEntActionUIUpdate" to "uiUpdate",
    "DtoEntActionUser" to "user"

)
val dtoMessagePayloadMapping = mapOf(
    "DtoMessagePayloadAudio" to "audio",
    "DtoMessagePayloadCamera" to "camera",
    "DtoMessagePayloadDocument" to "document",
    "DtoMessagePayloadGroup" to "group",
    "DtoMessagePayloadGroupAboutChange" to "groupAboutChange",
    "DtoMessagePayloadGroupAvatarChange" to "groupAvatarChange",
    "DtoMessagePayloadGroupCreate" to "groupCreate",
    "DtoMessagePayloadGroupExit" to "groupExit",
    "DtoMessagePayloadGroupJoinWithInvite" to "groupJoinWithInvite",
    "DtoMessagePayloadGroupMemberAdd" to "groupMemberAdd",
    "DtoMessagePayloadGroupMemberRemove" to "groupMemberRemove",
    "DtoMessagePayloadGroupNameChange" to "groupNameChange",
    "DtoMessagePayloadImage" to "image",
    "DtoMessagePayloadLinkText" to "linkText",
    "DtoMessagePayloadLocation" to "location",
    "DtoMessagePayloadMessageDeleted" to "messageDeleted",
    "DtoMessagePayloadReport" to "report",
    "DtoMessagePayloadSpreadsheetPartition" to "spreadsheetPartition",
    "DtoMessagePayloadSpreadsheetRow" to "spreadsheetRow",
    "DtoMessagePayloadSpreadsheetRowDeleted" to "spreadsheetRowDeleted",
    "DtoMessagePayloadText" to "text",
    "DtoMessagePayloadUser" to "user",
    "DtoMessagePayloadVideo" to "video",
    "DtoMessagePayloadVoice" to "voice"
)
