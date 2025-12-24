// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base



object Types
{
  enum class ServiceName(val value: String)
  {
    agent("agent"),
    ai("ai"),
    api("api"),
    aside("aside"),
    base("base"),
    cli("cli"),
    cluster("cluster"),
    deeplink("deeplink"),
    doc("doc"),
    drawer("drawer"),
    ent("ent"),
    entAside("entAside"),
    entDrawer("entDrawer"),
    entMain("entMain"),
    extn("extn"),
    main("main"),
    otp("otp"),
    rpc("rpc"),
    scheduler("scheduler"),
    session("session"),
    stem("stem"),
    store("store"),
    studioDrawer("studioDrawer"),
    studioEnt("studioEnt"),
    studioMain("studioMain"),
    task("task"),
    user("user"),
    wsoc("wsoc")
  }

  val AVATAR_CROP_QUALITY: Int = 1
  val AVATAR_MAX_MB: Double = 1.5
  val AVATAR_SIZE_MAX: Int = 640
  val AVATAR_SIZE_MIN: Int = 192
  val GRID_MAX_COUNT: Int = 20
  val PARAGRAPH_MAX_SIZE: Int = 10240
  val PREFIX_ADMIN_ID: String = "ea"
  val PREFIX_AUTOMATION_EXECUTION_ID: String = "ae"
  val PREFIX_CONN_ID: String = "conn"
  val PREFIX_DEMO_APP_ID: String = "dt"
  val PREFIX_DEVICE_ID: String = "d"
  val PREFIX_ENT_ID: String = "e"
  val PREFIX_ENT_USER_ID: String = "eu"
  val PREFIX_GHOST_ID: String = "gh"
  val PREFIX_GROUP_ID: String = "g"
  val PREFIX_INBOX_ID_FOLLOWER: String = "ii"
  val PREFIX_INBOX_ID_MASTER: String = "im"
  val PREFIX_INBOX_MESSAGE_ID: String = "imm"
  val PREFIX_KEYCHAIN_ID: String = "k"
  val PREFIX_KEYCHAIN_SECRET_ID: String = "ks"
  val PREFIX_MEDIA_ID_AUDIO: String = "ma"
  val PREFIX_MEDIA_ID_AVATAR: String = "mp"
  val PREFIX_MEDIA_ID_DOCUMENT: String = "md"
  val PREFIX_MEDIA_ID_IMAGE: String = "mi"
  val PREFIX_MEDIA_ID_JAR: String = "mj"
  val PREFIX_MEDIA_ID_STICKER: String = "ms"
  val PREFIX_MEDIA_ID_THUMBNAIL: String = "mt"
  val PREFIX_MEDIA_ID_VIDEO: String = "mv"
  val PREFIX_MEDIA_ID_VOICE: String = "mo"
  val PREFIX_MESSAGE_ID: String = "m"
  val PREFIX_META_ID_ACTION: String = "mac"
  val PREFIX_META_ID_AUTOMATION: String = "mau"
  val PREFIX_META_ID_CHART_X_AXIS: String = "mcx"
  val PREFIX_META_ID_CHART_Y_AXIS: String = "mcy"
  val PREFIX_META_ID_CODE: String = "mc"
  val PREFIX_META_ID_CONDITION: String = "mcn"
  val PREFIX_META_ID_DEEPLINK: String = "mdl"
  val PREFIX_META_ID_DRIVE_SHEET: String = "mds"
  val PREFIX_META_ID_EVENT: String = "mev"
  val PREFIX_META_ID_FIELD: String = "mfd"
  val PREFIX_META_ID_FIELD_DYNAMIC_CONDITION: String = "mfc"
  val PREFIX_META_ID_FIELD_DYNAMIC_RULE: String = "mfr"
  val PREFIX_META_ID_FOOTER: String = "mft"
  val PREFIX_META_ID_FORM: String = "mf"
  val PREFIX_META_ID_FORMULA: String = "mfm"
  val PREFIX_META_ID_FUNC_ARG: String = "mfa"
  val PREFIX_META_ID_GRID: String = "mgr"
  val PREFIX_META_ID_GROUP: String = "mgp"
  val PREFIX_META_ID_HEADER: String = "mhd"
  val PREFIX_META_ID_HYPERLINK: String = "mhl"
  val PREFIX_META_ID_LAYOUT_DRIVE_SHEET: String = "mld"
  val PREFIX_META_ID_LAYOUT_FORM: String = "mlf"
  val PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE: String = "mle"
  val PREFIX_META_ID_LAYOUT_GRID: String = "mlg"
  val PREFIX_META_ID_LAYOUT_USER: String = "mlu"
  val PREFIX_META_ID_MAPPING: String = "mg"
  val PREFIX_META_ID_MODULE: String = "mm"
  val PREFIX_META_ID_OPTION: String = "mop"
  val PREFIX_META_ID_PARTITION: String = "mpt"
  val PREFIX_META_ID_PAYMENT_PROVIDER: String = "mpp"
  val PREFIX_META_ID_PIPELINE_SYSTEM: String = "mps"
  val PREFIX_META_ID_PIPELINE_VAR: String = "mpv"
  val PREFIX_META_ID_PLUGIN: String = "mpl"
  val PREFIX_META_ID_PROMPT: String = "mpm"
  val PREFIX_META_ID_REPORT: String = "mrp"
  val PREFIX_META_ID_ROLE: String = "mr"
  val PREFIX_META_ID_SECTION: String = "msc"
  val PREFIX_META_ID_SPREADSHEET: String = "mss"
  val PREFIX_META_ID_SPREADSHEET_REF: String = "msr"
  val PREFIX_META_ID_STEP: String = "mst"
  val PREFIX_META_ID_SWIMLANE: String = "msw"
  val PREFIX_META_ID_TAB: String = "mtb"
  val PREFIX_META_ID_TABLE_STYLE: String = "mts"
  val PREFIX_META_ID_TRANSLATION: String = "mtl"
  val PREFIX_META_ID_USER_CONDITION: String = "muc"
  val PREFIX_META_ID_VAR: String = "mw"
  val PREFIX_META_ID_VD_AUTO_DIA: String = "va"
  val PREFIX_META_ID_VD_AUTO_EDGE: String = "vae"
  val PREFIX_META_ID_VD_AUTO_FUNC: String = "vaf"
  val PREFIX_META_ID_VD_AUTO_NODE: String = "van"
  val PREFIX_META_ID_VD_COMMENT: String = "vc"
  val PREFIX_META_ID_VD_ERD_DIA: String = "ve"
  val PREFIX_META_ID_VD_IMAGE_FUNC: String = "vif"
  val PREFIX_META_ID_VD_NOTE: String = "vn"
  val PREFIX_META_ID_VD_REGION: String = "vrg"
  val PREFIX_META_ID_VD_REPORT_DIA: String = "vr"
  val PREFIX_META_ID_VD_REVIEW: String = "vrv"
  val PREFIX_META_ID_VIDEO_TIMESTAMP: String = "mvt"
  val PREFIX_META_ID_VISIBILITY_ACTION: String = "mva"
  val PREFIX_META_ID_VISIBILITY_CONDITION: String = "mvc"
  val PREFIX_META_ID_VISIBILITY_RULE: String = "mvr"
  val PREFIX_META_ID_WIZARD: String = "mwz"
  val PREFIX_PLUGIN_API_ID: String = "pa"
  val PREFIX_PLUGIN_BUNDLE_ID: String = "pb"
  val PREFIX_PLUGIN_ID: String = "p"
  val PREFIX_PLUGIN_RESOURCE_ID: String = "pr"
  val PREFIX_REPORT_EXECUTION_ID: String = "re"
  val PREFIX_REQUEST_ID: String = "req"
  val PREFIX_ROW_ID: String = "r"
  val PREFIX_SCHEDULER_TASK_ID: String = "st"
  val PREFIX_SHEET_ID: String = "s"
  val PREFIX_SNAPSHOT_ID: String = "ss"
  val PREFIX_SPREADSHEET_PARTITION_ID: String = "sp"
  val PREFIX_STORE_ITEM_ID: String = "si"
  val PREFIX_TAB_ID: String = "t"
  val PREFIX_TRANSACTION_ID: String = "tr"
  val PREFIX_USER_ID: String = "u"
  val PREFIX_WORKFLOW_EXECUTION_ID: String = "we"
  val PREFIX_WORKFLOW_GROUP_EXECUTION_ID: String = "wg"
  val SCRIPT_MAX_SIZE: Int = 20480
  val SUFFIX_TEMPLATE: String = ".template"
  val THUMBNAIL_MAX_MB: Double = 0.25
  val THUMBNAIL_SIZE: Int = 144

  open class AdminId : SysId()
  open class ArtifactId : SysId()
  open class AutomationExecutionId : SysId()
  open class ChatId : SysId()
  open class ConnId : SysId()
  open class ContactId : ChatId()
  open class DemoAppId : SysId()
  open class DeviceId : SysId()
  open class EntId : ArtifactId()
  open class EntUserId : ContactId()
  open class GhostId : SysId()
  open class GroupId : ContactId()
  open class InboxId : SysId()
  open class InboxIdFollower : InboxId()
  open class InboxIdMaster : InboxId()
  open class InboxMessageId : SysId()
  open class KeychainId : SysId()
  open class KeychainSecretId : SysId()
  open class MediaId : SysId()
  open class MediaIdAudio : MediaId()
  open class MediaIdAvatar : MediaId()
  open class MediaIdDocument : MediaId()
  open class MediaIdIcon : MediaId()
  open class MediaIdImage : MediaId()
  open class MediaIdJar : MediaId()
  open class MediaIdSticker : MediaId()
  open class MediaIdThumbnail : MediaId()
  open class MediaIdVideo : MediaId()
  open class MediaIdVoice : MediaId()
  open class MessageId : SysId()
  open class MetaId : SysId()
  open class MetaIdAction : MetaId()
  open class MetaIdAutomation : MetaId()
  open class MetaIdChartXAxis : MetaId()
  open class MetaIdChartYAxis : MetaId()
  open class MetaIdCode : MetaId()
  open class MetaIdComp : MetaId()
  open class MetaIdComposite : MetaIdComp()
  open class MetaIdCondition : MetaId()
  open class MetaIdDeeplink : MetaId()
  open class MetaIdDriveSheet : MetaId()
  open class MetaIdEvent : MetaId()
  open class MetaIdField : MetaIdComp()
  open class MetaIdFieldDynamicCondition : MetaId()
  open class MetaIdFieldDynamicRule : MetaId()
  open class MetaIdFooter : MetaId()
  open class MetaIdForm : MetaId()
  open class MetaIdFormula : MetaId()
  open class MetaIdFuncArg : MetaId()
  open class MetaIdGrid : MetaIdComposite()
  open class MetaIdGroup : MetaId()
  open class MetaIdHeader : MetaId()
  open class MetaIdHyperlink : MetaId()
  open class MetaIdLayoutDriveSheet : MetaId()
  open class MetaIdLayoutForm : MetaId()
  open class MetaIdLayoutFormEditorComposite : MetaId()
  open class MetaIdLayoutGrid : MetaId()
  open class MetaIdLayoutUser : MetaId()
  open class MetaIdMapping : MetaId()
  open class MetaIdModule : MetaId()
  open class MetaIdOption : MetaId()
  open class MetaIdPartition : MetaId()
  open class MetaIdPaymentProvider : MetaId()
  open class MetaIdPipelineParam : MetaId()
  open class MetaIdPipelineSystem : MetaIdPipelineParam()
  open class MetaIdPipelineVar : MetaIdPipelineParam()
  open class MetaIdPlugin : MetaId()
  open class MetaIdPrompt : MetaId()
  open class MetaIdReport : MetaId()
  open class MetaIdRole : MetaId()
  open class MetaIdSection : MetaIdComposite()
  open class MetaIdSpreadsheet : MetaId()
  open class MetaIdSpreadsheetRef : MetaIdComposite()
  open class MetaIdStep : MetaIdPipelineParam()
  open class MetaIdSwimlane : MetaId()
  open class MetaIdTab : MetaIdComposite()
  open class MetaIdTableStyle : MetaId()
  open class MetaIdTranslation : MetaId()
  open class MetaIdUserCondition : MetaId()
  open class MetaIdVar : MetaId()
  open class MetaIdVdAutoDia : MetaId()
  open class MetaIdVdAutoEdge : MetaId()
  open class MetaIdVdAutoFunc : MetaId()
  open class MetaIdVdAutoNode : MetaIdPipelineParam()
  open class MetaIdVdComment : MetaId()
  open class MetaIdVdErdDia : MetaId()
  open class MetaIdVdImageFunc : MetaId()
  open class MetaIdVdNote : MetaId()
  open class MetaIdVdRegion : MetaId()
  open class MetaIdVdReportDia : MetaId()
  open class MetaIdVdReview : MetaId()
  open class MetaIdVideoTimestamp : MetaId()
  open class MetaIdVisibilityAction : MetaId()
  open class MetaIdVisibilityCondition : MetaId()
  open class MetaIdVisibilityRule : MetaId()
  open class MetaIdWizard : MetaIdComposite()
  open class PluginApiId : SysId()
  open class PluginBundleId : ArtifactId()
  open class PluginId : SysId()
  open class PluginResourceId : SysId()
  open class ReportExecutionId : SysId()
  open class RequestId : SysId()
  open class RowId : ChatId()
  open class SchedulerTaskId : SysId()
  open class SheetId : SysId()
  open class SnapshotId : SysId()
  open class SpreadsheetPartitionId : SysId()
  open class StoreItemId : ArtifactId()

  open class TabId : SysId()
  open class TransactionId : SysId()
  open class UserId : SysId()
  open class WorkflowExecutionId : SysId()
  open class WorkflowGroupExecutionId : SysId()

  class AnyTime : AnyValue()
  class ColumnPath : AnyValue()
  class CurrencyKey : AnyKey()
  class GeoPoint : AnyValue()
  class HandleKey : AnyKey()
  class Key : AnyKey()
  class LanguageKey : AnyKey()
  class SearchPath : AnyValue()
  class SymbolColumn : AnyValue()
  class SymbolGrid : AnyValue()
  class TimeZoneKey : AnyKey()

  enum class DtoLogTreeKeyValueType(val value: String)
  {
    neoQL("neoQL"),
    json("json"),
    javascript("javascript"),
    xml("xml"),
    regular("regular")
  }

  enum class EnumContactCopyField(val value: String)
  {
    firstName("firstName"),
    lastName("lastName"),
    fullName("fullName"),
    mobileNumber("mobileNumber"),
    email("email"),
    address("address"),
    birthDate("birthDate")
  }

  enum class EnumDefnAdminDoNotOptionEnt(val value: String)
  {
    actions("actions"),
    adminPermissions("adminPermissions"),
    admins("admins"),
    backend("backend"),
    debug("debug"),
    debugApiBrowser("debugApiBrowser"),
    debugAutomation("debugAutomation"),
    debugLogs("debugLogs"),
    debugQuery("debugQuery"),
    debugWorkflow("debugWorkflow"),
    deeplinks("deeplinks"),
    deploy("deploy"),
    deployInfo("deployInfo"),
    deployPayment("deployPayment"),
    deployPlugins("deployPlugins"),
    deployVariables("deployVariables"),
    driveSheets("driveSheets"),
    extensions("extensions"),
    facets("facets"),
    forms("forms"),
    formulas("formulas"),
    frontend("frontend"),
    groups("groups"),
    layouts("layouts"),
    manage("manage"),
    manageDashboard("manageDashboard"),
    manageKeychain("manageKeychain"),
    managePayment("managePayment"),
    manageSettings("manageSettings"),
    menus("menus"),
    modules("modules"),
    permissions("permissions"),
    plugins("plugins"),
    reports("reports"),
    roles("roles"),
    spreadsheets("spreadsheets"),
    theme("theme"),
    tools("tools"),
    toolsDemoApp("toolsDemoApp"),
    toolsWidgetWizard("toolsWidgetWizard"),
    translations("translations"),
    users("users"),
    variables("variables"),
    visibilityRules("visibilityRules"),
    workflows("workflows")
  }

  enum class EnumDefnAdminDoNotOptionPlugin(val value: String)
  {
    admins("admins")
  }

  enum class EnumDefnAdminDoNotOptionStoreItem(val value: String)
  {
    admins("admins")
  }

  enum class EnumDefnAdminPermissionType(val value: String)
  {
    doNotEdit("doNotEdit"),
    doNotShow("doNotShow")
  }

  enum class EnumDefnArgBinder(val value: String)
  {
    argument("argument"),
    context_("context"),
    derived("derived"),
    field("field"),
    input("input"),
    output("output"),
    spreadsheet("spreadsheet"),
    sep("sep"),
    variable("variable"),
    constant("constant"),
    response("response"),
    refTarget("refTarget"),
    parameter("parameter")
  }

  enum class EnumDefnArgBinderArgument(val value: String)
  {
    selectedSectionId("selectedSectionId"),
    selectedGridId("selectedGridId"),
    selectedCompositeId("selectedCompositeId"),
    selectedGridRowId("selectedGridRowId")
  }

  enum class EnumDefnArgBinderContext(val value: String)
  {
    caller("caller"),
    callerSetting("callerSetting"),
    ent("ent"),
    form("form"),
    plugin("plugin"),
    pluginConfig("pluginConfig"),
    row("row")
  }

  enum class EnumDefnArgBinderContextCaller(val value: String)
  {
    color("color"),
    entUserId("entUserId"),
    handle("handle"),
    managerId("managerId"),
    assistantIds("assistantIds"),
    allAssistantIds("allAssistantIds"),
    allManagerIds("allManagerIds"),
    grandManagerId("grandManagerId"),
    nickName("nickName"),
    userId("userId"),
    email("email"),
    mobileNumber("mobileNumber"),
    roles("roles")
  }

  enum class EnumDefnArgBinderContextEnt(val value: String)
  {
    about("about"),
    id("id"),
    name_("name"),
    timeZone("timeZone"),
    displayDateFormat("displayDateFormat"),
    systemEntUserId("systemEntUserId")
  }

  enum class EnumDefnArgBinderContextForm(val value: String)
  {
    id("id"),
    name_("name"),
    label("label")
  }

  enum class EnumDefnArgBinderContextPlugin(val value: String)
  {
    about("about"),
    id("id"),
    name_("name")
  }

  enum class EnumDefnArgBinderContextRow(val value: String)
  {
    createdBy("createdBy"),
    createdOn("createdOn"),
    id("id"),
    order("order"),
    parentId("parentId"),
    type("type"),
    updatedBy("updatedBy"),
    updatedOn("updatedOn")
  }

  enum class EnumDefnAudioFormat(val value: String)
  {
    ogg("ogg"),
    mp3("mp3"),
    wav("wav")
  }

  enum class EnumDefnAutomationSource(val value: String)
  {
    currentForm("currentForm"),
    currentGrid("currentGrid")
  }

  enum class EnumDefnAutomationTerminateKind(val value: String)
  {
    terminate("terminate"),
    resume("resume"),
    setField("setField")
  }

  enum class EnumDefnAutomationWebhookKind(val value: String)
  {
    location("location"),
    neomeComment("neomeComment"),
    neomeUserSession("neomeUserSession"),
    razorpayPaymentReceipt("razorpayPaymentReceipt")
  }

  enum class EnumDefnButtonTargetType(val value: String)
  {
    callReport("callReport"),
    invokePlugin("invokePlugin"),
    saveToSpreadsheet("saveToSpreadsheet"),
    sendWhatsAppMessage("sendWhatsAppMessage"),
    triggerAction("triggerAction"),
    executeCallable("executeCallable"),
    startLocationTracking("startLocationTracking"),
    stopLocationTracking("stopLocationTracking")
  }

  enum class EnumDefnCalculateFormulaMode(val value: String)
  {
    automatic("automatic"),
    manual("manual"),
    onSend("onSend")
  }

  enum class EnumDefnCaptureMode(val value: String)
  {
    manual("manual"),
    onInsert("onInsert"),
    onUpdate("onUpdate")
  }

  enum class EnumDefnCaptureValueKind(val value: String)
  {
    captureLocation("captureLocation"),
    captureTime("captureTime"),
    captureUser("captureUser")
  }

  enum class EnumDefnChartRenderingMode(val value: String)
  {
    horizontal("horizontal"),
    vertical("vertical")
  }

  enum class EnumDefnCodeEditorLanguage(val value: String)
  {
    csv("csv"),
    html("html"),
    javascript("javascript"),
    json("json"),
    neoQL("neoQL"),
    sql("sql"),
    text("text"),
    xml("xml")
  }

  enum class EnumDefnCodeType(val value: String)
  {
    barCode("barCode"),
    qrCode("qrCode")
  }

  enum class EnumDefnCompType(val value: String)
  {
    bool("bool"),
    date("date"),
    decimal("decimal"),
    logDecimal("logDecimal"),
    image("image"),
    label("label"),
    number("number"),
    logNumber("logNumber"),
    paragraph("paragraph"),
    text("text"),
    enumAdminDoNotOptionEnt("enumAdminDoNotOptionEnt"),
    enumAdminDoNotOptionPlugin("enumAdminDoNotOptionPlugin"),
    enumAudioFormat("enumAudioFormat"),
    enumAutomationSource("enumAutomationSource"),
    enumCaptureValueKind("enumCaptureValueKind"),
    enumCodeEditorLanguage("enumCodeEditorLanguage"),
    enumConditionOperator("enumConditionOperator"),
    enumConjunction("enumConjunction"),
    enumDataPartitionPeriod("enumDataPartitionPeriod"),
    enumDate("enumDate"),
    enumDay("enumDay"),
    enumDeeplinkConstraints("enumDeeplinkConstraints"),
    enumDeployVar("enumDeployVar"),
    enumDeviceSize("enumDeviceSize"),
    enumDeviceType("enumDeviceType"),
    enumDocFileExt("enumDocFileExt"),
    enumDriveStatus("enumDriveStatus"),
    enumDurationUnit("enumDurationUnit"),
    enumEntLockBehavior("enumEntLockBehavior"),
    enumEntLockReason("enumEntLockReason"),
    enumFields("enumFields"),
    enumFuncArgs("enumFuncArgs"),
    enumMapPinShape("enumMapPinShape"),
    enumPaymentMethod("enumPaymentMethod"),
    enumPaymentPlan("enumPaymentPlan"),
    enumPermission("enumPermission"),
    enumPluginApiMethod("enumPluginApiMethod"),
    enumPluginResources("enumPluginResources"),
    enumPluginSecurityAccess("enumPluginSecurityAccess"),
    enumPromptAction("enumPromptAction"),
    enumRoles("enumRoles"),
    enumRowAuditTrail("enumRowAuditTrail"),
    enumSetupKind("enumSetupKind"),
    enumUserSettingOptions("enumUserSettingOptions"),
    enumUserSettingValue("enumUserSettingValue"),
    enumVideoFormat("enumVideoFormat"),
    enumVisibilityOperator("enumVisibilityOperator"),
    enumMonth("enumMonth"),
    enumQuarter("enumQuarter"),
    enumDeeplinkExpiry("enumDeeplinkExpiry"),
    enumForms("enumForms"),
    enumLogOperationKind("enumLogOperationKind"),
    enumCodeType("enumCodeType"),
    enumPosition("enumPosition"),
    enumDateOccurrence("enumDateOccurrence"),
    enumFrequencyKind("enumFrequencyKind"),
    enumRenderingKind("enumRenderingKind"),
    enumInsertVariant("enumInsertVariant"),
    enumUpdateVariant("enumUpdateVariant"),
    enumRemoveVariant("enumRemoveVariant"),
    enumEmptyFieldVariant("enumEmptyFieldVariant"),
    enumTableLayoutStyle("enumTableLayoutStyle"),
    enumUserProperty("enumUserProperty"),
    enumRowProperty("enumRowProperty"),
    enumStoreItem("enumStoreItem"),
    enumCaptureMode("enumCaptureMode"),
    enumLockOperation("enumLockOperation"),
    enumRefreshOn("enumRefreshOn"),
    enumEditorLayoutRenderingMode("enumEditorLayoutRenderingMode"),
    enumFormLayoutType("enumFormLayoutType"),
    enumSetOfUserKind("enumSetOfUserKind"),
    enumUserContext("enumUserContext"),
    enumDynamicOperator("enumDynamicOperator"),
    enumTargetType("enumTargetType"),
    enumDriveSheetLayoutFor("enumDriveSheetLayoutFor"),
    enumDriveSheetFieldLayoutOn("enumDriveSheetFieldLayoutOn"),
    enumTextStyle("enumTextStyle"),
    enumContentAlignment("enumContentAlignment"),
    enumUserProps("enumUserProps"),
    enumGridRenderingMode("enumGridRenderingMode"),
    enumPaymentMethodKind("enumPaymentMethodKind"),
    enumSortOrder("enumSortOrder"),
    enumTextValidationPattern("enumTextValidationPattern"),
    enumSyncMode("enumSyncMode"),
    enumPluginMode("enumPluginMode"),
    enumMapRenderingMode("enumMapRenderingMode"),
    enumCalculateFormulaMode("enumCalculateFormulaMode"),
    enumEjectionPolicy("enumEjectionPolicy"),
    enumRefSetOperationKind("enumRefSetOperationKind"),
    enumEntStage("enumEntStage"),
    enumFreezeAvatarKind("enumFreezeAvatarKind"),
    enumTableLayoutTheme("enumTableLayoutTheme"),
    enumChartRenderingMode("enumChartRenderingMode"),
    enumThemeImageRenderingMode("enumThemeImageRenderingMode"),
    enumPromptAttachmentFormat("enumPromptAttachmentFormat"),
    enumLocationCapturingMode("enumLocationCapturingMode"),
    enumArgBinderContext("enumArgBinderContext"),
    enumArgBinder("enumArgBinder"),
    enumKindAction("enumKindAction"),
    enumKindActionUIUpdate("enumKindActionUIUpdate"),
    enumKindAutomation("enumKindAutomation"),
    enumKindButton("enumKindButton"),
    enumKindDeeplink("enumKindDeeplink"),
    enumKindFormComposite("enumKindFormComposite"),
    enumKindHyperlink("enumKindHyperlink"),
    enumKindImport("enumKindImport"),
    enumKindRating("enumKindRating"),
    enumKindReport("enumKindReport"),
    enumKindScheduledEvent("enumKindScheduledEvent"),
    enumKindAutomationStep("enumKindAutomationStep"),
    enumKindSpreadsheetEvent("enumKindSpreadsheetEvent"),
    enumKindPluginWebhookEvent("enumKindPluginWebhookEvent"),
    enumKindWebhookEvent("enumKindWebhookEvent"),
    enumKindTranslation("enumKindTranslation"),
    enumTerminateSetting("enumTerminateSetting"),
    enumAutomationWebhookKind("enumAutomationWebhookKind"),
    enumLocationAccuracy("enumLocationAccuracy"),
    enumKindAutoEdge("enumKindAutoEdge"),
    enumKindAutoNode("enumKindAutoNode"),
    enumLayoutCardFilterKind("enumLayoutCardFilterKind"),
    enumLayoutGridKind("enumLayoutGridKind"),
    enumThemeButtonSize("enumThemeButtonSize"),
    enumThemeButtonVariant("enumThemeButtonVariant"),
    enumThemeColor("enumThemeColor"),
    enumThemeColorShade("enumThemeColorShade"),
    enumThemeDirection("enumThemeDirection"),
    enumThemeDividerThickness("enumThemeDividerThickness"),
    enumThemeFieldMargin("enumThemeFieldMargin"),
    enumThemeFieldSize("enumThemeFieldSize"),
    enumThemeFieldVariant("enumThemeFieldVariant"),
    enumThemeFormVariant("enumThemeFormVariant"),
    enumThemeImageCorner("enumThemeImageCorner"),
    enumThemePickVariant("enumThemePickVariant"),
    enumThemePickMultiVariant("enumThemePickMultiVariant"),
    enumPlacement("enumPlacement"),
    enumThemeSectionVariant("enumThemeSectionVariant"),
    enumThemeStroke("enumThemeStroke"),
    enumThemeTabVariant("enumThemeTabVariant"),
    enumVisibilityAction("enumVisibilityAction"),
    enumVisibilityActionOn("enumVisibilityActionOn"),
    enumWizardNavigationMode("enumWizardNavigationMode"),
    currency("currency"),
    icon("icon"),
    language("language"),
    timeZone("timeZone"),
    pinShape("pinShape"),
    lineStroke("lineStroke"),
    month("month"),
    quarter("quarter"),
    textSize("textSize"),
    paymentStatus("paymentStatus"),
    messageKind("messageKind"),
    chipSet("chipSet"),
    chipSetDate("chipSetDate"),
    chipSetDateTime("chipSetDateTime"),
    chipSetDay("chipSetDay"),
    chipSetDeviceSize("chipSetDeviceSize"),
    chipSetDeviceType("chipSetDeviceType"),
    chipSetTime("chipSetTime"),
    pickRole("pickRole"),
    pickText("pickText"),
    pickTree("pickTree"),
    pickUser("pickUser"),
    pickGridRow("pickGridRow"),
    pickReportRow("pickReportRow"),
    setOfRole("setOfRole"),
    setOfUser("setOfUser"),
    setOfText("setOfText"),
    color("color"),
    hyperlink("hyperlink"),
    audio("audio"),
    camera("camera"),
    counter("counter"),
    logCounter("logCounter"),
    dateRange("dateRange"),
    dateTime("dateTime"),
    dateTimeRange("dateTimeRange"),
    duration("duration"),
    email("email"),
    handle("handle"),
    location("location"),
    mobileNumber("mobileNumber"),
    rating("rating"),
    signature("signature"),
    slider("slider"),
    time("time"),
    video("video"),
    voice("voice"),
    geoPoint("geoPoint"),
    rowId("rowId"),
    symbol("symbol"),
    schedulerId("schedulerId"),
    spreadsheetId("spreadsheetId"),
    button("button"),
    divider("divider"),
    document("document"),
    error("error"),
    html("html"),
    identifier("identifier"),
    info("info"),
    propertyMap("propertyMap"),
    scanCode("scanCode"),
    setOfDocument("setOfDocument"),
    showCode("showCode"),
    userId("userId"),
    dynamic("dynamic"),
    hyperlinkRow("hyperlinkRow"),
    password("password"),
    ref("ref"),
    refSet("refSet"),
    refUser("refUser"),
    refReport("refReport"),
    refTarget("refTarget"),
    refContact("refContact"),
    grid("grid"),
    section("section"),
    spreadsheetRef("spreadsheetRef"),
    tab("tab"),
    wizard("wizard"),
    dateFormat("dateFormat"),
    studioVarIdTextEditor("studioVarIdTextEditor"),
    studioVarIdParagraphEditor("studioVarIdParagraphEditor"),
    studioCodeEditor("studioCodeEditor"),
    pickActionId("pickActionId"),
    pickCompId("pickCompId"),
    pickPluginCompId("pickPluginCompId"),
    pickFieldId("pickFieldId"),
    pickPluginFieldId("pickPluginFieldId"),
    pickFormId("pickFormId"),
    pickPluginFormId("pickPluginFormId"),
    pickGridId("pickGridId"),
    pickImportPluginId("pickImportPluginId"),
    pickImportPluginApiId("pickImportPluginApiId"),
    pickLayoutFormContentId("pickLayoutFormContentId"),
    pickLayoutGridId("pickLayoutGridId"),
    pickSpreadsheetRefLayoutId("pickSpreadsheetRefLayoutId"),
    pickLayoutSpreadsheetId("pickLayoutSpreadsheetId"),
    pickPluginBundleId("pickPluginBundleId"),
    pickPluginId("pickPluginId"),
    pickReportId("pickReportId"),
    pickSectionId("pickSectionId"),
    pickSpreadsheetId("pickSpreadsheetId"),
    pickVarId("pickVarId"),
    pickGroupId("pickGroupId"),
    pickDeeplinkId("pickDeeplinkId"),
    pickPipelineVarId("pickPipelineVarId"),
    pickDeployPaymentProviderId("pickDeployPaymentProviderId"),
    pickAutomationId("pickAutomationId"),
    studioBuildAllModules("studioBuildAllModules"),
    studioBuildArgBinder("studioBuildArgBinder"),
    studioSetOfDate("studioSetOfDate"),
    studioBuildColor("studioBuildColor"),
    studioBuildDate("studioBuildDate"),
    studioBuildDateTime("studioBuildDateTime"),
    studioBuildPermissionMatrix("studioBuildPermissionMatrix"),
    studioBuildTree("studioBuildTree"),
    studioBuildUserSetting("studioBuildUserSetting"),
    studioBuildActionPermission("studioBuildActionPermission"),
    studioBuildPropertyMap("studioBuildPropertyMap"),
    studioBuildMapping("studioBuildMapping"),
    studioBuildVideoTimestampMap("studioBuildVideoTimestampMap"),
    studioBuildOptionPermissionMatrix("studioBuildOptionPermissionMatrix"),
    studioMapOfForwardRolePermission("studioMapOfForwardRolePermission"),
    studioMapOfCondition("studioMapOfCondition"),
    studioMapOfFormula("studioMapOfFormula"),
    studioMapOfFuncArg("studioMapOfFuncArg"),
    studioMapOfJarFile("studioMapOfJarFile"),
    studioMapOfLayoutSpreadsheet("studioMapOfLayoutSpreadsheet"),
    studioMapOfLayoutGrid("studioMapOfLayoutGrid"),
    studioMapOfText("studioMapOfText"),
    studioMapOfVisibilityCondition("studioMapOfVisibilityCondition"),
    studioMapOfVisibilityAction("studioMapOfVisibilityAction"),
    studioMapOfPartition("studioMapOfPartition"),
    studioMapOfForwardGroupPermission("studioMapOfForwardGroupPermission"),
    studioMapOfDynamicRule("studioMapOfDynamicRule"),
    studioMapOfPipelineVariable("studioMapOfPipelineVariable"),
    studioMapOfDynamicCondition("studioMapOfDynamicCondition"),
    studioMapOfUserCondition("studioMapOfUserCondition"),
    studioMapOfLayoutDriveSpreadsheet("studioMapOfLayoutDriveSpreadsheet"),
    studioFieldMappingTree("studioFieldMappingTree"),
    studioGridMappingTree("studioGridMappingTree"),
    studioMapOfArgBinder("studioMapOfArgBinder"),
    studioMapOfRefTargetSpreadsheet("studioMapOfRefTargetSpreadsheet"),
    studioSetOfDocFileExt("studioSetOfDocFileExt"),
    studioSetOfStoreItemCategory("studioSetOfStoreItemCategory"),
    studioSetOfModule("studioSetOfModule"),
    studioSetOfNumber("studioSetOfNumber"),
    studioSetOfAdminDoNotOption("studioSetOfAdminDoNotOption"),
    studioSetOfPluginSecurityAccess("studioSetOfPluginSecurityAccess"),
    studioSetOfRowAuditTrail("studioSetOfRowAuditTrail"),
    studioSetOfMonth("studioSetOfMonth"),
    studioSetOfBorder("studioSetOfBorder"),
    studioSetOfBorderRadius("studioSetOfBorderRadius"),
    studioSetOfCompId("studioSetOfCompId"),
    studioSetOfDataExportKind("studioSetOfDataExportKind"),
    studioSetOfLanguageKeys("studioSetOfLanguageKeys"),
    studioSetOfActionId("studioSetOfActionId"),
    studioSetOfFieldId("studioSetOfFieldId"),
    studioSetOfPluginFieldId("studioSetOfPluginFieldId"),
    studioSetOfFieldRefId("studioSetOfFieldRefId"),
    studioSetOfFormId("studioSetOfFormId"),
    studioSetOfGridId("studioSetOfGridId"),
    studioSetOfGroupId("studioSetOfGroupId"),
    studioSetOfLayoutFormContentId("studioSetOfLayoutFormContentId"),
    studioSetOfLayoutGridId("studioSetOfLayoutGridId"),
    studioSetOfLayoutSpreadsheetId("studioSetOfLayoutSpreadsheetId"),
    studioSetOfReportId("studioSetOfReportId"),
    studioSetOfSectionId("studioSetOfSectionId"),
    studioSetOfSpreadsheetId("studioSetOfSpreadsheetId"),
    studioSetOfVarId("studioSetOfVarId"),
    studioCompArray("studioCompArray"),
    otp("otp"),
    avtar("avtar"),
    carousel("carousel"),
    formList("formList"),
    formListItem("formListItem"),
    pickOption("pickOption"),
    wallpaper("wallpaper")
  }

  enum class EnumDefnConditionOperator(val value: String)
  {
    hasNoValue("hasNoValue"),
    equalTo("equalTo"),
    greaterThan("greaterThan"),
    greaterThanOrEqualTo("greaterThanOrEqualTo"),
    hasValue("hasValue"),
    lessThan("lessThan"),
    lessThanOrEqualTo("lessThanOrEqualTo"),
    notEqualTo("notEqualTo"),
    contains("contains"),
    notContains("notContains")
  }

  enum class EnumDefnConjunction(val value: String)
  {
    or("or"),
    and("and")
  }

  enum class EnumDefnContentAlignment(val value: String)
  {
    start("start"),
    center("center"),
    end("end")
  }

  enum class EnumDefnDataExportKind(val value: String)
  {
    xlsx("xlsx"),
    json("json")
  }

  enum class EnumDefnDataPartitionPeriod(val value: String)
  {
    daily("daily"),
    hourly("hourly"),
    weekly("weekly"),
    monthly("monthly"),
    quarterly("quarterly"),
    yearly("yearly")
  }

  enum class EnumDefnDate(val value: String)
  {
    lastQuarter("lastQuarter"),
    lastWeek("lastWeek"),
    lastMonth("lastMonth"),
    lastYear("lastYear"),
    nextQuarter("nextQuarter"),
    nextWeek("nextWeek"),
    nextMonth("nextMonth"),
    nextYear("nextYear"),
    now("now"),
    tomorrow("tomorrow"),
    yesterday("yesterday"),
    startOfWeek("startOfWeek"),
    startOfMonth("startOfMonth"),
    startOfYear("startOfYear"),
    endOfWeek("endOfWeek"),
    endOfMonth("endOfMonth"),
    endOfYear("endOfYear"),
    createdOn("createdOn"),
    updatedOn("updatedOn")
  }

  enum class EnumDefnDateOccurrence(val value: String)
  {
    custom("custom"),
    first("first"),
    last("last")
  }

  enum class EnumDefnDay(val value: String)
  {
    sunday("sunday"),
    monday("monday"),
    tuesday("tuesday"),
    wednesday("wednesday"),
    thursday("thursday"),
    friday("friday"),
    saturday("saturday")
  }

  enum class EnumDefnDeeplinkConstraint(val value: String)
  {
    enforceGlobalUserSignIn("enforceGlobalUserSignIn"),
    enforceEnterpriseUserSignIn("enforceEnterpriseUserSignIn"),
    makeAnEnterpriseUser("makeAnEnterpriseUser"),
    allowPublicSharing("allowPublicSharing")
  }

  enum class EnumDefnDeeplinkExpiry(val value: String)
  {
    onFirstClick("onFirstClick"),
    withinOneWeek("withinOneWeek"),
    withinOneMonth("withinOneMonth"),
    noExpiry("noExpiry")
  }

  enum class EnumDefnDeploy(val value: String)
  {
    requiredOnDeploy("requiredOnDeploy"),
    fixedOnDeploy("fixedOnDeploy")
  }

  enum class EnumDefnDeviceSize(val value: String)
  {
    mobile("mobile"),
    tablet("tablet"),
    laptop("laptop"),
    desktop("desktop")
  }

  enum class EnumDefnDocFileExt(val value: String)
  {
    ai("ai"),
    any("any"),
    avi("avi"),
    cdr("cdr"),
    csv("csv"),
    dll("dll"),
    doc("doc"),
    docx("docx"),
    drawio("drawio"),
    dwg("dwg"),
    eml("eml"),
    gif("gif"),
    html("html"),
    jar("jar"),
    jpeg("jpeg"),
    jpg("jpg"),
    json("json"),
    mov("mov"),
    mp3("mp3"),
    mp4("mp4"),
    msg("msg"),
    oga("oga"),
    ogg("ogg"),
    pdf("pdf"),
    png("png"),
    ppt("ppt"),
    pptx("pptx"),
    rvt("rvt"),
    std("std"),
    svg("svg"),
    tiff("tiff"),
    txt("txt"),
    wav("wav"),
    webm("webm"),
    xls("xls"),
    xlsx("xlsx"),
    xml("xml"),
    zip("zip")
  }

  enum class EnumDefnDriveSheetFieldLayoutOn(val value: String)
  {
    column("column"),
    header_("header")
  }

  enum class EnumDefnDriveSheetLayoutFor(val value: String)
  {
    sectionOrGrid("sectionOrGrid"),
    field("field")
  }

  enum class EnumDefnDriveStatus(val value: String)
  {
    connected("connected"),
    disconnected("disconnected"),
    notInstalled("notInstalled")
  }

  enum class EnumDefnDurationUnit(val value: String)
  {
    seconds("seconds"),
    minutes("minutes"),
    hours("hours"),
    days("days"),
    weeks("weeks"),
    months("months"),
    quarters("quarters"),
    years("years")
  }

  enum class EnumDefnDynamicOperator(val value: String)
  {
    hasNoValue("hasNoValue"),
    hasValue("hasValue"),
    equalTo("equalTo"),
    notEqualTo("notEqualTo")
  }

  enum class EnumDefnEditorLayoutRenderingMode(val value: String)
  {
    tabs("tabs"),
    stack("stack"),
    wizard("wizard")
  }

  enum class EnumDefnEjectionPolicy(val value: String)
  {
    FIFO("FIFO"),
    LIFO("LIFO")
  }

  enum class EnumDefnEmptyFieldVariant(val value: String)
  {
    ignoreEmptyField("ignoreEmptyField"),
    overrideEmptyField("overrideEmptyField")
  }

  enum class EnumDefnEntLockBehavior(val value: String)
  {
    readAccess("readAccess"),
    zeroAccess("zeroAccess"),
    fullAccessWithWarning("fullAccessWithWarning")
  }

  enum class EnumDefnEntLockReason(val value: String)
  {
    blocked("blocked"),
    obsolete("obsolete"),
    other("other"),
    paymentNotReceived("paymentNotReceived"),
    tooMuchLoad("tooMuchLoad"),
    userUpgrade("userUpgrade")
  }

  enum class EnumDefnEntStage(val value: String)
  {
    Created("Created"),
    POC("POC"),
    UserInvited("UserInvited"),
    Production("Production")
  }

  enum class EnumDefnErrorSeverity(val value: String)
  {
    error("error"),
    suggestion("suggestion"),
    warning("warning")
  }

  enum class EnumDefnFields(val value: String)
  {
    _CreatedBy("\$CreatedBy"),
    _CreatedOn("\$CreatedOn"),
    _RowId("\$RowId"),
    _RowOrder("\$RowOrder"),
    _UpdatedBy("\$UpdatedBy"),
    _UpdatedOn("\$UpdatedOn"),
    _ParentRowId("\$ParentRowId")
  }

  enum class EnumDefnFormLayoutType(val value: String)
  {
    editor("editor"),
    content("content"),
    template("template")
  }

  enum class EnumDefnForms(val value: String)
  {
    _FormMapOfOptions("\$FormMapOfOptions"),
    _FormPickTree("\$FormPickTree"),
    _FormSetOfUser("\$FormSetOfUser"),
    _FormPluginConfig("\$FormPluginConfig"),
    _FormSchedule("\$FormSchedule"),
    _FormPaymentReceipt("\$FormPaymentReceipt"),
    _FormUserSession("\$FormUserSession"),
    _FormRowComment("\$FormRowComment"),
    _FormLocation("\$FormLocation"),
    _FormEntAdmin("\$FormEntAdmin"),
    _FormEntUser("\$FormEntUser"),
    _FormEntAuditRecord("\$FormEntAuditRecord"),
    _FormPrompt("\$FormPrompt"),
    _FormRagPromptResponse("\$FormRagPromptResponse"),
    _FormRowEditHistory("\$FormRowEditHistory"),
    _FormHumanLink("\$FormHumanLink"),
    _FormUserMembership("\$FormUserMembership"),
    _FormCrawl("\$FormCrawl"),
    _FormSearch("\$FormSearch"),
    _FormBotResponse("\$FormBotResponse"),
    _FormBotHistory("\$FormBotHistory")
  }

  enum class EnumDefnFreezeAvatarKind(val value: String)
  {
    rounded("rounded"),
    square("square")
  }

  enum class EnumDefnFuncArg(val value: String)
  {
    number("number"),
    text("text"),
    numberArray("numberArray"),
    textArray("textArray")
  }

  enum class EnumDefnGridRenderingMode(val value: String)
  {
    auto("auto"),
    flex("flex")
  }

  enum class EnumDefnHttpMethod(val value: String)
  {
    delete("delete"),
    get("get"),
    patch("patch"),
    post("post"),
    put("put")
  }

  enum class EnumDefnInsertVariant(val value: String)
  {
    insertForced("insertForced"),
    skipEmptyKeyField("skipEmptyKeyField"),
    doNotInsert("doNotInsert")
  }

  enum class EnumDefnKindAction(val value: String)
  {
    executeCallable("executeCallable"),
    report("report"),
    rowInsert("rowInsert"),
    rowUpdate("rowUpdate"),
    spreadsheetEditor("spreadsheetEditor"),
    spreadsheetHistory("spreadsheetHistory"),
    uiUpdate("uiUpdate"),
    user("user")
  }

  enum class EnumDefnKindActionUIUpdate(val value: String)
  {
    groupSwitcher("groupSwitcher")
  }

  enum class EnumDefnKindAiProvider(val value: String)
  {
    openAI_4_1_MINI("openAI_4_1_MINI"),
    openAI_5("openAI_5")
  }

  enum class EnumDefnKindAutoEdge(val value: String)
  {
    ERROR("ERROR"),
    EXPIRY("EXPIRY"),
    FALSE_("FALSE"),
    ITERATE("ITERATE"),
    NEXT("NEXT"),
    TRUE_("TRUE"),
    VALUE("VALUE")
  }

  enum class EnumDefnKindAutoNode(val value: String)
  {
    acquireLock("acquireLock"),
    aiAgent("aiAgent"),
    aiAudioToText("aiAudioToText"),
    aiDocumentToForm("aiDocumentToForm"),
    aiExcelToSpreadsheet("aiExcelToSpreadsheet"),
    aiFakerToForm("aiFakerToForm"),
    aiFakerToSpreadsheet("aiFakerToSpreadsheet"),
    aiFormToClassification("aiFormToClassification"),
    aiFormToForm("aiFormToForm"),
    aiFormToHtml("aiFormToHtml"),
    aiFormToImage("aiFormToImage"),
    aiFormToJSON("aiFormToJSON"),
    aiFormToPDF("aiFormToPDF"),
    aiFormToSentiment("aiFormToSentiment"),
    aiFormToSummary("aiFormToSummary"),
    aiFormToXML("aiFormToXML"),
    aiSpreadsheetToCSV("aiSpreadsheetToCSV"),
    aiSpreadsheetToExcel("aiSpreadsheetToExcel"),
    aiSpreadsheetToHTML("aiSpreadsheetToHTML"),
    aiSpreadsheetToJSON("aiSpreadsheetToJSON"),
    aiSpreadsheetToPDF("aiSpreadsheetToPDF"),
    aiSpreadsheetToXML("aiSpreadsheetToXML"),
    aiTextToClassification("aiTextToClassification"),
    aiTextToForm("aiTextToForm"),
    aiTextToJSON("aiTextToJSON"),
    aiTextToSentiment("aiTextToSentiment"),
    aiTextToSummary("aiTextToSummary"),
    aiTextToXML("aiTextToXML"),
    aiXMLToForm("aiXMLToForm"),
    aiXMLToSpreadsheet("aiXMLToSpreadsheet"),
    applyFormula("applyFormula"),
    applyTransforms("applyTransforms"),
    botBuildResponse("botBuildResponse"),
    botHistoryAddPrompt("botHistoryAddPrompt"),
    botHistoryAddResponse("botHistoryAddResponse"),
    botHistoryGet("botHistoryGet"),
    botHistoryRemove("botHistoryRemove"),
    botHistoryToStory("botHistoryToStory"),
    botSendResponse("botSendResponse"),
    branchIfElse("branchIfElse"),
    branchIterateArray("branchIterateArray"),
    branchIterateGrid("branchIterateGrid"),
    branchIterateSpreadsheet("branchIterateSpreadsheet"),
    branchSwitchCase("branchSwitchCase"),
    branchSwitchForm("branchSwitchForm"),
    branchSwitchPrompt("branchSwitchPrompt"),
    debugLog("debugLog"),
    eventChat("eventChat"),
    eventHumanLink("eventHumanLink"),
    eventManualTrigger("eventManualTrigger"),
    eventPaymentReceipt("eventPaymentReceipt"),
    eventPluginWebhook("eventPluginWebhook"),
    eventRowComment("eventRowComment"),
    eventRpcCall("eventRpcCall"),
    eventSchedule("eventSchedule"),
    eventSsInsertAfter("eventSsInsertAfter"),
    eventSsInsertBefore("eventSsInsertBefore"),
    eventSsRemoveAfter("eventSsRemoveAfter"),
    eventSsRemoveBefore("eventSsRemoveBefore"),
    eventSsUpdateAfter("eventSsUpdateAfter"),
    eventSsUpdateBefore("eventSsUpdateBefore"),
    eventSubWorkflow("eventSubWorkflow"),
    eventUserExit("eventUserExit"),
    eventUserJoin("eventUserJoin"),
    eventUserLocation("eventUserLocation"),
    eventUserOffline("eventUserOffline"),
    eventUserOnline("eventUserOnline"),
    executeAction("executeAction"),
    executeJavascript("executeJavascript"),
    executeParallel("executeParallel"),
    executePlugin("executePlugin"),
    executeReport("executeReport"),
    executeRpc("executeRpc"),
    executeScheduler("executeScheduler"),
    executeSchedulerRemove("executeSchedulerRemove"),
    executeSubWorkflow("executeSubWorkflow"),
    fieldRefSetSet("fieldRefSetSet"),
    fieldRemove("fieldRemove"),
    fieldSet("fieldSet"),
    generateDeeplink("generateDeeplink"),
    generateImage("generateImage"),
    generatePaymentLink("generatePaymentLink"),
    generatePdf("generatePdf"),
    imageTransforms("imageTransforms"),
    mediaExists("mediaExists"),
    mediaRemove("mediaRemove"),
    paramCalc("paramCalc"),
    paramClone("paramClone"),
    paramCreate("paramCreate"),
    paramExist("paramExist"),
    paramRemove("paramRemove"),
    paramUpdate("paramUpdate"),
    pause("pause"),
    releaseLock("releaseLock"),
    resume("resume"),
    rowForward("rowForward"),
    rowGet("rowGet"),
    rowGetHistory("rowGetHistory"),
    rowInsert("rowInsert"),
    rowInsertPartitionRequest("rowInsertPartitionRequest"),
    rowRemove("rowRemove"),
    rowSendComment("rowSendComment"),
    rowUpdate("rowUpdate"),
    rowUpdateFieldLogNumber("rowUpdateFieldLogNumber"),
    sendEmail("sendEmail"),
    sendHumanLink("sendHumanLink"),
    sendMessageToGroups("sendMessageToGroups"),
    sendMessageToUsers("sendMessageToUsers"),
    sendPushNotification("sendPushNotification"),
    sendWhatsappMessage("sendWhatsappMessage"),
    sendWhatsappTemplate("sendWhatsappTemplate"),
    ssCrawl("ssCrawl"),
    ssExecuteQuery("ssExecuteQuery"),
    ssFtsSearch("ssFtsSearch"),
    ssRagSearch("ssRagSearch"),
    ssRemoveRows("ssRemoveRows"),
    stopAndError("stopAndError"),
    userAdd("userAdd"),
    userGet("userGet"),
    userGetAllAssistants("userGetAllAssistants"),
    userGetAssistants("userGetAssistants"),
    userGetGrandManager("userGetGrandManager"),
    userGetManager("userGetManager"),
    userHasGrandManager("userHasGrandManager"),
    userHasManager("userHasManager"),
    userHasRoles("userHasRoles"),
    userIsAllAssistant("userIsAllAssistant"),
    userIsAllManager("userIsAllManager"),
    userIsAssistant("userIsAssistant"),
    userIsGrandManager("userIsGrandManager"),
    userIsManager("userIsManager"),
    userIterate("userIterate"),
    userRemove("userRemove"),
    userUpdate("userUpdate"),
    validate("validate"),
    validatePrompt("validatePrompt"),
    wait("wait")
  }

  enum class EnumDefnKindAutoResponseWait(val value: String)
  {
    all("all"),
    anyOne("anyOne"),
    none("none")
  }

  enum class EnumDefnKindAutoXform(val value: String)
  {
    stringJoiner("stringJoiner"),
    stringIsMobileNumber("stringIsMobileNumber"),
    stringIsEmail("stringIsEmail")
  }

  enum class EnumDefnKindAutomation(val value: String)
  {
    callable("callable"),
    pluginWebhook("pluginWebhook"),
    scheduled("scheduled"),
    spreadsheet("spreadsheet"),
    webhook("webhook")
  }

  enum class EnumDefnKindAutomationStep(val value: String)
  {
    addUser("addUser"),
    updateUser("updateUser"),
    calculateFormulas("calculateFormulas"),
    callPlugin("callPlugin"),
    callReport("callReport"),
    copyField("copyField"),
    forwardToGroups("forwardToGroups"),
    forwardToUsers("forwardToUsers"),
    generateDeeplink("generateDeeplink"),
    getSpreadsheetRow("getSpreadsheetRow"),
    getSpreadsheetRows("getSpreadsheetRows"),
    validation("validation"),
    insertIntoSpreadsheet("insertIntoSpreadsheet"),
    lock("lock"),
    sendMessage("sendMessage"),
    sendMessageToUsers("sendMessageToUsers"),
    sendMessageAsComment("sendMessageAsComment"),
    sendMessageToGroups("sendMessageToGroups"),
    generatePdf("generatePdf"),
    generateImage("generateImage"),
    generatePaymentLink("generatePaymentLink"),
    sendWhatsappTemplateMessage("sendWhatsappTemplateMessage"),
    sendWhatsappDynamicMessage("sendWhatsappDynamicMessage"),
    sendEmail("sendEmail"),
    sendPushNotification("sendPushNotification"),
    partitionSend("partitionSend"),
    pause("pause"),
    removeField("removeField"),
    removeFromSpreadsheet("removeFromSpreadsheet"),
    removeCurrentRow("removeCurrentRow"),
    removeRows("removeRows"),
    removeUser("removeUser"),
    returnEvent("returnEvent"),
    terminate("terminate"),
    updateField("updateField"),
    updateFieldLogNumber("updateFieldLogNumber"),
    updateFieldRefSet("updateFieldRefSet"),
    updateSpreadsheet("updateSpreadsheet"),
    execute("execute"),
    executeAsync("executeAsync"),
    clearPipeline("clearPipeline"),
    parseDocument("parseDocument"),
    addSchedule("addSchedule"),
    removeSchedule("removeSchedule")
  }

  enum class EnumDefnKindBranchIfElse(val value: String)
  {
    Condition("Condition"),
    ConditionVar("ConditionVar")
  }

  enum class EnumDefnKindButton(val value: String)
  {
    submit("submit"),
    reset("reset"),
    refresh("refresh"),
    normal("normal")
  }

  enum class EnumDefnKindCallableEvent(val value: String)
  {
    onFire("onFire")
  }

  enum class EnumDefnKindChannelType(val value: String)
  {
    email("email"),
    neome("neome"),
    slack("slack"),
    sms("sms"),
    whatsapp("whatsapp")
  }

  enum class EnumDefnKindDeeplink(val value: String)
  {
    report("report"),
    spreadsheetEditor("spreadsheetEditor"),
    spreadsheetInsert("spreadsheetInsert"),
    spreadsheetRow("spreadsheetRow")
  }

  enum class EnumDefnKindFormComposite(val value: String)
  {
    grid("grid"),
    section("section"),
    spreadsheetRef("spreadsheetRef")
  }

  enum class EnumDefnKindHyperlink(val value: String)
  {
    general("general"),
    youtube("youtube")
  }

  enum class EnumDefnKindImageXform(val value: String)
  {
    blur("blur")
  }

  enum class EnumDefnKindImport(val value: String)
  {
    plugin("plugin")
  }

  enum class EnumDefnKindMessage(val value: String)
  {
    audio("audio"),
    camera("camera"),
    document("document"),
    image("image"),
    linkText("linkText"),
    location("location"),
    text("text"),
    video("video"),
    user("user"),
    voice("voice")
  }

  enum class EnumDefnKindNoteStatus(val value: String)
  {
    Done("Done"),
    Error("Error"),
    Start("Start"),
    Verify("Verify")
  }

  enum class EnumDefnKindPipelineUpdate(val value: String)
  {
    Mapping("Mapping"),
    MappingVar("MappingVar")
  }

  enum class EnumDefnKindPluginWebhookEvent(val value: String)
  {
    onCallback("onCallback")
  }

  enum class EnumDefnKindRating(val value: String)
  {
    heart_1("heart_1"),
    thumbs_2("thumbs_2"),
    star_3("star_3"),
    star_4("star_4"),
    star_5("star_5")
  }

  enum class EnumDefnKindReport(val value: String)
  {
    composite("composite"),
    mapper("mapper"),
    plugin("plugin"),
    query("query"),
    spreadsheet("spreadsheet")
  }

  enum class EnumDefnKindScheduledEvent(val value: String)
  {
    onExpiry("onExpiry")
  }

  enum class EnumDefnKindSentiment(val value: String)
  {
    VeryPositive("VeryPositive"),
    Positive("Positive"),
    Neutral("Neutral"),
    Negative("Negative"),
    VeryNegative("VeryNegative")
  }

  enum class EnumDefnKindSetOfUser(val value: String)
  {
    roles("roles"),
    fields("fields"),
    context_("context")
  }

  enum class EnumDefnKindSpreadsheetEvent(val value: String)
  {
    afterInsert("afterInsert"),
    afterRemove("afterRemove"),
    afterUpdate("afterUpdate"),
    beforeInsert("beforeInsert"),
    beforeRemove("beforeRemove"),
    beforeUpdate("beforeUpdate")
  }

  enum class EnumDefnKindTranslation(val value: String)
  {
    text("text"),
    paragraph("paragraph")
  }

  enum class EnumDefnKindWebhookEvent(val value: String)
  {
    onCallback("onCallback")
  }

  enum class EnumDefnLayoutCardFilterKind(val value: String)
  {
    tree("tree"),
    tab("tab")
  }

  enum class EnumDefnLayoutGridKind(val value: String)
  {
    card("card"),
    list("list"),
    map("map"),
    table("table"),
    kanban("kanban"),
    calendar("calendar"),
    xyChartBarGraph("xyChartBarGraph"),
    xyChartLineChart("xyChartLineChart"),
    xyChartPieChart("xyChartPieChart"),
    xyChartDoughnut("xyChartDoughnut"),
    xyChartScatterPlot("xyChartScatterPlot")
  }

  enum class EnumDefnLayoutUserKind(val value: String)
  {
    hierarchy("hierarchy"),
    tree("tree")
  }

  enum class EnumDefnLocationAccuracy(val value: String)
  {
    high("high"),
    balanced("balanced"),
    low("low")
  }

  enum class EnumDefnLocationCapturingMode(val value: String)
  {
    scheduled("scheduled"),
    manual("manual")
  }

  enum class EnumDefnLockOperation(val value: String)
  {
    acquire("acquire"),
    release("release")
  }

  enum class EnumDefnLogOperationKind(val value: String)
  {
    add("add"),
    subtract("subtract"),
    set("set")
  }

  enum class EnumDefnMapPinShape(val value: String)
  {
    avatar("avatar"),
    avatarWithName("avatarWithName"),
    circle("circle"),
    circleBig("circleBig"),
    circleMedium("circleMedium"),
    circleWithLabel("circleWithLabel"),
    heart("heart"),
    heartBig("heartBig"),
    heartMedium("heartMedium"),
    label("label"),
    pin("pin"),
    pinWithLabel("pinWithLabel"),
    square("square"),
    squareBig("squareBig"),
    squareMedium("squareMedium"),
    star("star"),
    starBig("starBig"),
    starMedium("starMedium"),
    triangle("triangle"),
    triangleBig("triangleBig"),
    triangleMedium("triangleMedium")
  }

  enum class EnumDefnMapRenderingMode(val value: String)
  {
    fixedLocation("fixedLocation"),
    liveLocation("liveLocation")
  }

  enum class EnumDefnMonth(val value: String)
  {
    January("January"),
    February("February"),
    March("March"),
    April("April"),
    May("May"),
    June("June"),
    July("July"),
    August("August"),
    September("September"),
    October("October"),
    November("November"),
    December("December"),
    CurrentMonth("CurrentMonth"),
    PreviousMonth("PreviousMonth"),
    NextMonth("NextMonth")
  }

  enum class EnumDefnNodeTerminateKind(val value: String)
  {
    resume("resume"),
    stopOrErrorBranch("stopOrErrorBranch")
  }

  enum class EnumDefnPaymentMethod(val value: String)
  {
    creditCard("creditCard"),
    debitCard("debitCard")
  }

  enum class EnumDefnPaymentMethodKind(val value: String)
  {
    netbanking("netbanking"),
    card("card"),
    upi("upi")
  }

  enum class EnumDefnPaymentPlan(val value: String)
  {
    free("free"),
    team("team"),
    business("business"),
    onPremise("onPremise")
  }

  enum class EnumDefnPaymentStatus(val value: String)
  {
    pending("pending"),
    paid("paid"),
    failed("failed")
  }

  enum class EnumDefnPermission(val value: String)
  {
    hide("hide"),
    read("read"),
    writeOnInsert("writeOnInsert"),
    writeOnce("writeOnce"),
    invisible("invisible"),
    write("write")
  }

  enum class EnumDefnPipelineFormKind(val value: String)
  {
    input("input"),
    output("output")
  }

  enum class EnumDefnPipelineSystem(val value: String)
  {
    _Curr("\$Curr"),
    _Iter("\$Iter"),
    _Out("\$Out"),
    _Prev("\$Prev"),
    _Prior("\$Prior"),
    _Sys("\$Sys")
  }

  enum class EnumDefnPlacement(val value: String)
  {
    top("top"),
    bottom("bottom"),
    start("start"),
    end("end"),
    center("center"),
    diagonal("diagonal"),
    overlayTop("overlayTop"),
    flexCenter("flexCenter"),
    spaceBetween("spaceBetween"),
    justify("justify")
  }

  enum class EnumDefnPluginApiMethod(val value: String)
  {
    delete("delete"),
    get("get"),
    patch("patch"),
    post("post"),
    put("put"),
    webhook("webhook"),
    function("function")
  }

  enum class EnumDefnPluginMode(val value: String)
  {
    agent("agent"),
    javascript("javascript"),
    webService("webService")
  }

  enum class EnumDefnPluginResources(val value: String)
  {
    jar("jar"),
    rpc("rpc"),
    dev("dev")
  }

  enum class EnumDefnPluginSecurityAccess(val value: String)
  {
    drive("drive"),
    network("network")
  }

  enum class EnumDefnPosition(val value: String)
  {
    topLeft("topLeft"),
    topRight("topRight"),
    bottomLeft("bottomLeft"),
    bottomRight("bottomRight")
  }

  enum class EnumDefnPromptAction(val value: String)
  {
    insert("insert"),
    update("update"),
    remove("remove"),
    get("get")
  }

  enum class EnumDefnPromptAttachmentFormat(val value: String)
  {
    pdf("pdf"),
    image("image")
  }

  enum class EnumDefnQuarter(val value: String)
  {
    Quarter_1("Quarter_1"),
    Quarter_2("Quarter_2"),
    Quarter_3("Quarter_3"),
    Quarter_4("Quarter_4")
  }

  enum class EnumDefnRefSetOperationKind(val value: String)
  {
    set("set"),
    union("union"),
    intersection("intersection"),
    insert("insert"),
    put("put"),
    remove("remove"),
    moveUp("moveUp"),
    moveDown("moveDown"),
    moveTop("moveTop"),
    moveBottom("moveBottom"),
    sort("sort")
  }

  enum class EnumDefnRefreshOn(val value: String)
  {
    refreshOnOpen("refreshOnOpen"),
    refreshOnSend("refreshOnSend"),
    refreshOnDemand("refreshOnDemand")
  }

  enum class EnumDefnRemoveVariant(val value: String)
  {
    removeForced("removeForced"),
    doNotRemove("doNotRemove")
  }

  enum class EnumDefnRenderingKind(val value: String)
  {
    a4Size("a4Size"),
    custom("custom"),
    fitToScreen("fitToScreen"),
    fullScreen("fullScreen"),
    mm_48("mm_48"),
    mm_58("mm_58"),
    mm_72("mm_72"),
    mm_80("mm_80"),
    mm_104("mm_104"),
    receiptSize("receiptSize")
  }

  enum class EnumDefnRepeatFrequencyKind(val value: String)
  {
    minutes("minutes"),
    hours("hours"),
    days("days"),
    weeks("weeks"),
    months("months"),
    years("years")
  }

  enum class EnumDefnRoles(val value: String)
  {
    _Public("\$Public"),
    _Manager("\$Manager"),
    _GrandManager("\$GrandManager"),
    _AllManagers("\$AllManagers"),
    _Assistants("\$Assistants"),
    _AllAssistants("\$AllAssistants"),
    _Self("\$Self")
  }

  enum class EnumDefnRowAuditTrail(val value: String)
  {
    insert("insert"),
    update("update"),
    remove("remove")
  }

  enum class EnumDefnRowProperty(val value: String)
  {
    createdBy("createdBy"),
    updatedBy("updatedBy")
  }

  enum class EnumDefnScanCodeType(val value: String)
  {
    barCode("barCode"),
    qrCode("qrCode")
  }

  enum class EnumDefnSetupKind(val value: String)
  {
    quick("quick"),
    standard("standard"),
    advanced("advanced"),
    focusDeploy("focusDeploy"),
    focusBackend("focusBackend"),
    focusFrontend("focusFrontend")
  }

  enum class EnumDefnShowBorderKind(val value: String)
  {
    top("top"),
    bottom("bottom"),
    left("left"),
    right("right")
  }

  enum class EnumDefnShowBorderRadiusKind(val value: String)
  {
    topLeft("topLeft"),
    topRight("topRight"),
    bottomLeft("bottomLeft"),
    bottomRight("bottomRight")
  }

  enum class EnumDefnSortOrder(val value: String)
  {
    ascending("ascending"),
    descending("descending")
  }

  enum class EnumDefnStoreItem(val value: String)
  {
    template("template"),
    application("application")
  }

  enum class EnumDefnSyncMode(val value: String)
  {
    backup("backup"),
    biDirectional("biDirectional")
  }

  enum class EnumDefnTableLayoutTheme(val value: String)
  {
    standard("standard"),
    spacious("spacious")
  }

  enum class EnumDefnTableStyle(val value: String)
  {
    defaultStyle("defaultStyle")
  }

  enum class EnumDefnTextSize(val value: String)
  {
    body1("body1"),
    body2("body2"),
    button("button"),
    caption("caption"),
    h1("h1"),
    h2("h2"),
    h3("h3"),
    h4("h4"),
    h5("h5"),
    h6("h6"),
    inherit("inherit"),
    overline("overline"),
    subtitle1("subtitle1"),
    subtitle2("subtitle2"),
    subtitle3("subtitle3"),
    subtitle4("subtitle4")
  }

  enum class EnumDefnTextStyle(val value: String)
  {
    bold("bold"),
    italic("italic"),
    underlined("underlined"),
    strikeout("strikeout")
  }

  enum class EnumDefnTextValidationPattern(val value: String)
  {
    aadhaar("aadhaar"),
    gstin("gstin"),
    pan("pan")
  }

  enum class EnumDefnThemeButtonSize(val value: String)
  {
    small("small"),
    medium("medium"),
    large("large")
  }

  enum class EnumDefnThemeButtonVariant(val value: String)
  {
    text("text"),
    contained("contained"),
    outlined("outlined"),
    icon("icon")
  }

  enum class EnumDefnThemeColor(val value: String)
  {
    transparent("transparent"),
    primary("primary"),
    secondary("secondary"),
    error("error"),
    info("info"),
    success("success"),
    warning("warning"),
    textPrimary("textPrimary"),
    textSecondary("textSecondary"),
    textDisabled("textDisabled"),
    textInverse("textInverse"),
    primaryLight("primaryLight"),
    secondaryLight("secondaryLight"),
    successLight("successLight"),
    errorLight("errorLight"),
    infoLight("infoLight"),
    warningLight("warningLight"),
    primaryDark("primaryDark"),
    secondaryDark("secondaryDark"),
    successDark("successDark"),
    errorDark("errorDark"),
    infoDark("infoDark"),
    warningDark("warningDark"),
    amber("amber"),
    black("black"),
    blue("blue"),
    cyan("cyan"),
    deepOrange("deepOrange"),
    deepPurple("deepPurple"),
    green("green"),
    grey("grey"),
    indigo("indigo"),
    lightBlue("lightBlue"),
    lightGreen("lightGreen"),
    lime("lime"),
    orange("orange"),
    pink("pink"),
    purple("purple"),
    red("red"),
    teal("teal"),
    white("white"),
    yellow("yellow")
  }

  enum class EnumDefnThemeColorShade(val value: String)
  {
    s50("s50"),
    s100("s100"),
    s200("s200"),
    s300("s300"),
    s400("s400"),
    s500("s500")
  }

  enum class EnumDefnThemeDirection(val value: String)
  {
    horizontal("horizontal"),
    vertical("vertical")
  }

  enum class EnumDefnThemeDividerKind(val value: String)
  {
    thick("thick"),
    thin("thin")
  }

  enum class EnumDefnThemeFieldMargin(val value: String)
  {
    dense("dense"),
    none("none"),
    normal("normal")
  }

  enum class EnumDefnThemeFieldSize(val value: String)
  {
    medium("medium"),
    small("small")
  }

  enum class EnumDefnThemeFieldVariant(val value: String)
  {
    outlined("outlined"),
    filled("filled"),
    standard("standard")
  }

  enum class EnumDefnThemeFormVariant(val value: String)
  {
    form("form"),
    report("report")
  }

  enum class EnumDefnThemeImageCorner(val value: String)
  {
    rectangle("rectangle"),
    circle("circle"),
    rounded("rounded")
  }

  enum class EnumDefnThemeImageRenderingMode(val value: String)
  {
    aspectFit("aspectFit"),
    scaleToFit("scaleToFit")
  }

  enum class EnumDefnThemePickMultiVariant(val value: String)
  {
    checkboxVertical("checkboxVertical"),
    checkboxHorizontal("checkboxHorizontal"),
    dropdown("dropdown")
  }

  enum class EnumDefnThemePickVariant(val value: String)
  {
    radioButtonVertical("radioButtonVertical"),
    radioButtonHorizontal("radioButtonHorizontal"),
    led("led"),
    dropdown("dropdown")
  }

  enum class EnumDefnThemeSectionVariant(val value: String)
  {
    form("form"),
    propertyEditor("propertyEditor")
  }

  enum class EnumDefnThemeStroke(val value: String)
  {
    dash("dash"),
    dotted("dotted"),
    solid("solid")
  }

  enum class EnumDefnThemeTabVariant(val value: String)
  {
    standard("standard"),
    scrollable("scrollable"),
    fullWidth("fullWidth")
  }

  enum class EnumDefnTime(val value: String)
  {
    now("now")
  }

  enum class EnumDefnUpdateVariant(val value: String)
  {
    updateForced("updateForced"),
    doNotUpdate("doNotUpdate")
  }

  enum class EnumDefnUserContext(val value: String)
  {
    caller("caller"),
    createdBy("createdBy"),
    updatedBy("updatedBy")
  }

  enum class EnumDefnUserProperty(val value: String)
  {
    nickName("nickName"),
    handle("handle")
  }

  enum class EnumDefnUserProps(val value: String)
  {
    firstName("firstName"),
    lastName("lastName"),
    fullName("fullName"),
    email("email"),
    mobileNumber("mobileNumber"),
    handle("handle")
  }

  enum class EnumDefnUserSettingOptions(val value: String)
  {
    text("text"),
    number("number"),
    decimal("decimal"),
    pickOne("pickOne"),
    pickMany("pickMany")
  }

  enum class EnumDefnUserSettingValue(val value: String)
  {
    dataEntered("dataEntered"),
    dataNotEntered("dataNotEntered")
  }

  enum class EnumDefnVideoFormat(val value: String)
  {
    mp4("mp4")
  }

  enum class EnumDefnVisibilityAction(val value: String)
  {
    blink("blink"),
    click("click"),
    clear("clear"),
    setValue("setValue"),
    disable("disable"),
    enable("enable"),
    executeAction("executeAction"),
    hidden("hidden"),
    highlight("highlight"),
    invisible("invisible"),
    shake("shake"),
    visible("visible")
  }

  enum class EnumDefnVisibilityActionOn(val value: String)
  {
    component("component"),
    field("field"),
    layout("layout"),
    sendButton("sendButton")
  }

  enum class EnumDefnVisibilityOperator(val value: String)
  {
    hasNoValue("hasNoValue"),
    hasValue("hasValue"),
    equalTo("equalTo"),
    notEqualTo("notEqualTo"),
    hasChanged("hasChanged")
  }

  enum class EnumDefnWizardNavigationMode(val value: String)
  {
    nextButton("nextButton"),
    nextPreviousButton("nextPreviousButton")
  }

  enum class EnumDeviceType(val value: String)
  {
    android("android"),
    ios("ios"),
    web("web"),
    widget("widget"),
    agent("agent"),
    test("test")
  }

  enum class EnumEnvValidationError(val value: String)
  {
    cli("cli"),
    composite("composite"),
    invalidParam("invalidParam"),
    notAccessible("notAccessible"),
    notChanged("notChanged"),
    notFound("notFound"),
    ruleViolation("ruleViolation")
  }

  enum class EnumFormContentPosition(val value: String)
  {
    start("start"),
    flexCenter("flexCenter"),
    end("end")
  }

  enum class EnumFormExportType(val value: String)
  {
    pdf("pdf"),
    image("image"),
    html("html")
  }

  enum class EnumIdentityProviderKind(val value: String)
  {
    apple("apple"),
    google("google"),
    microsoft("microsoft")
  }

  enum class EnumKeychainType(val value: String)
  {
    rpcReceive("rpcReceive"),
    rpcSend("rpcSend"),
    slack("slack")
  }

  enum class EnumLogItemType(val value: String)
  {
    text("text"),
    tree("tree"),
    table("table")
  }

  enum class EnumLogTableAlignment(val value: String)
  {
    left("left"),
    center("center"),
    right("right")
  }

  enum class EnumLogTableTextStyle(val value: String)
  {
    plain("plain"),
    bold("bold"),
    italic("italic"),
    underline("underline"),
    strikeThrough("strikeThrough"),
    boldItalic("boldItalic"),
    boldUnderline("boldUnderline"),
    boldStrikeThrough("boldStrikeThrough")
  }

  enum class EnumLogTextType(val value: String)
  {
    neoQL("neoQL"),
    cli("cli"),
    json("json"),
    plain("plain"),
    monospaced("monospaced"),
    javascript("javascript"),
    html("html"),
    xml("xml")
  }

  enum class EnumLogTreeItemType(val value: String)
  {
    keyValue("keyValue"),
    line("line")
  }

  enum class EnumLogTreeLineCollapse(val value: String)
  {
    showCollapse("showCollapse"),
    showExpand("showExpand"),
    ignore("ignore")
  }

  enum class EnumMediaType(val value: String)
  {
    audio("audio"),
    document("document"),
    icon("icon"),
    image("image"),
    jar("jar"),
    avatar("avatar"),
    sticker("sticker"),
    thumbnail("thumbnail"),
    video("video"),
    voice("voice")
  }

  enum class EnumNeatPathCaption(val value: String)
  {
    About("About"),
    Plugins("Plugins"),
    Roles("Roles"),
    Variables("Variables"),
    Translations("Translations"),
    Forms("Forms"),
    Reports("Reports"),
    Spreadsheets("Spreadsheets"),
    Actions("Actions"),
    Groups("Groups"),
    Deeplinks("Deeplinks"),
    DriveSheets("DriveSheets"),
    Deploy("Deploy"),
    Automation("Automation"),
    Admins("Admins"),
    Users("Users"),
    Details("Details"),
    API("API"),
    Resources("Resources"),
    Store("Store")
  }

  enum class EnumPaymentProviderKind(val value: String)
  {
    razorpay("razorpay")
  }

  enum class EnumSchemaColumnType(val value: String)
  {
    Boolean("Boolean"),
    Date("Date"),
    DateArray("DateArray"),
    Double("Double"),
    GeoHash("GeoHash"),
    GeoPoint("GeoPoint"),
    Long("Long"),
    String("String"),
    StringArray("StringArray"),
    SysId("SysId"),
    LongArray("LongArray"),
    SysIdArray("SysIdArray")
  }

  enum class EnumStoreItemArtifact(val value: String)
  {
    ent("ent"),
    plugin("plugin"),
    template("template")
  }

  enum class EnumStoreLabel(val value: String)
  {
    CRM("CRM"),
    Demo("Demo"),
    Ffreedom("Ffreedom"),
    Hubspot("Hubspot"),
    Neome("Neome"),
    Plugin("Plugin"),
    SalesForce("SalesForce"),
    ServiceNow("ServiceNow"),
    Tally("Tally"),
    Ticketing("Ticketing"),
    Zendesk("Zendesk")
  }

  enum class EnumStudioCompType(val value: String)
  {
    bool("bool"),
    date("date"),
    decimal("decimal"),
    logDecimal("logDecimal"),
    image("image"),
    label("label"),
    number("number"),
    logNumber("logNumber"),
    paragraph("paragraph"),
    text("text"),
    chipSet("chipSet"),
    chipSetDate("chipSetDate"),
    chipSetDateTime("chipSetDateTime"),
    chipSetDay("chipSetDay"),
    chipSetDeviceSize("chipSetDeviceSize"),
    chipSetDeviceType("chipSetDeviceType"),
    chipSetTime("chipSetTime"),
    currency("currency"),
    icon("icon"),
    language("language"),
    timeZone("timeZone"),
    pinShape("pinShape"),
    lineStroke("lineStroke"),
    paymentStatus("paymentStatus"),
    month("month"),
    quarter("quarter"),
    textSize("textSize"),
    messageKind("messageKind"),
    pickRole("pickRole"),
    pickText("pickText"),
    pickTree("pickTree"),
    pickUser("pickUser"),
    pickGridRow("pickGridRow"),
    pickReportRow("pickReportRow"),
    setOfRole("setOfRole"),
    setOfUser("setOfUser"),
    setOfText("setOfText"),
    color("color"),
    hyperlink("hyperlink"),
    audio("audio"),
    camera("camera"),
    counter("counter"),
    logCounter("logCounter"),
    dateRange("dateRange"),
    dateTime("dateTime"),
    dateTimeRange("dateTimeRange"),
    duration("duration"),
    email("email"),
    handle("handle"),
    location("location"),
    mobileNumber("mobileNumber"),
    rating("rating"),
    signature("signature"),
    slider("slider"),
    time("time"),
    video("video"),
    voice("voice"),
    geoPoint("geoPoint"),
    rowId("rowId"),
    symbol("symbol"),
    schedulerId("schedulerId"),
    spreadsheetId("spreadsheetId"),
    button("button"),
    divider("divider"),
    document("document"),
    error("error"),
    html("html"),
    identifier("identifier"),
    info("info"),
    propertyMap("propertyMap"),
    scanCode("scanCode"),
    setOfDocument("setOfDocument"),
    showCode("showCode"),
    userId("userId"),
    dynamic("dynamic"),
    hyperlinkRow("hyperlinkRow"),
    password("password"),
    ref("ref"),
    refSet("refSet"),
    refUser("refUser"),
    refReport("refReport"),
    refTarget("refTarget"),
    refContact("refContact"),
    grid("grid"),
    section("section"),
    spreadsheetRef("spreadsheetRef")
  }

  enum class EnumStudioVarKind(val value: String)
  {
    any("any"),
    bool("bool"),
    buttonVariant("buttonVariant"),
    color("color"),
    currency("currency"),
    date("date"),
    dateTime("dateTime"),
    day("day"),
    decimal("decimal"),
    deviceSize("deviceSize"),
    deviceType("deviceType"),
    direction("direction"),
    dividerKind("dividerKind"),
    document("document"),
    duration("duration"),
    email("email"),
    textSize("textSize"),
    html("html"),
    hyperlink("hyperlink"),
    icon("icon"),
    image("image"),
    imageCorner("imageCorner"),
    language("language"),
    location("location"),
    mapPinShape("mapPinShape"),
    mobileNumber("mobileNumber"),
    number("number"),
    paragraph("paragraph"),
    ratingKind("ratingKind"),
    stroke("stroke"),
    symbol("symbol"),
    text("text"),
    placement("placement"),
    time("time"),
    timeZone("timeZone"),
    month("month"),
    quarter("quarter"),
    condition("condition"),
    function("function"),
    mapping("mapping"),
    sequence("sequence"),
    userSetting("userSetting"),
    mapOfText("mapOfText"),
    setOfDate("setOfDate"),
    setOfDay("setOfDay"),
    setOfNumber("setOfNumber"),
    setOfText("setOfText"),
    setOfTime("setOfTime"),
    setOfUser("setOfUser"),
    tree("tree")
  }

  enum class EnumWhatsAppTemplateHeaderType(val value: String)
  {
    none("none"),
    video("video"),
    document("document"),
    image("image")
  }
  private val prefixSysIdClassMap: MutableMap<String, Class<out SysId>> = mutableMapOf()
  private val sysIdClassPrefixMap: MutableMap<Class<out SysId>, String> = mutableMapOf()

  init
  {
    prefixSysIdClassMap[PREFIX_ADMIN_ID] = AdminId::class.java
    prefixSysIdClassMap[PREFIX_AUTOMATION_EXECUTION_ID] = AutomationExecutionId::class.java
    prefixSysIdClassMap[PREFIX_CONN_ID] = ConnId::class.java
    prefixSysIdClassMap[PREFIX_DEMO_APP_ID] = DemoAppId::class.java
    prefixSysIdClassMap[PREFIX_DEVICE_ID] = DeviceId::class.java
    prefixSysIdClassMap[PREFIX_ENT_ID] = EntId::class.java
    prefixSysIdClassMap[PREFIX_ENT_USER_ID] = EntUserId::class.java
    prefixSysIdClassMap[PREFIX_GHOST_ID] = GhostId::class.java
    prefixSysIdClassMap[PREFIX_GROUP_ID] = GroupId::class.java
    prefixSysIdClassMap[PREFIX_INBOX_ID_FOLLOWER] = InboxIdFollower::class.java
    prefixSysIdClassMap[PREFIX_INBOX_ID_MASTER] = InboxIdMaster::class.java
    prefixSysIdClassMap[PREFIX_INBOX_MESSAGE_ID] = InboxMessageId::class.java
    prefixSysIdClassMap[PREFIX_KEYCHAIN_ID] = KeychainId::class.java
    prefixSysIdClassMap[PREFIX_KEYCHAIN_SECRET_ID] = KeychainSecretId::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_AUDIO] = MediaIdAudio::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_AVATAR] = MediaIdAvatar::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_DOCUMENT] = MediaIdDocument::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_IMAGE] = MediaIdImage::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_JAR] = MediaIdJar::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_STICKER] = MediaIdSticker::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_THUMBNAIL] = MediaIdThumbnail::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_VIDEO] = MediaIdVideo::class.java
    prefixSysIdClassMap[PREFIX_MEDIA_ID_VOICE] = MediaIdVoice::class.java
    prefixSysIdClassMap[PREFIX_MESSAGE_ID] = MessageId::class.java
    prefixSysIdClassMap[PREFIX_META_ID_ACTION] = MetaIdAction::class.java
    prefixSysIdClassMap[PREFIX_META_ID_AUTOMATION] = MetaIdAutomation::class.java
    prefixSysIdClassMap[PREFIX_META_ID_CHART_X_AXIS] = MetaIdChartXAxis::class.java
    prefixSysIdClassMap[PREFIX_META_ID_CHART_Y_AXIS] = MetaIdChartYAxis::class.java
    prefixSysIdClassMap[PREFIX_META_ID_CODE] = MetaIdCode::class.java
    prefixSysIdClassMap[PREFIX_META_ID_CONDITION] = MetaIdCondition::class.java
    prefixSysIdClassMap[PREFIX_META_ID_DEEPLINK] = MetaIdDeeplink::class.java
    prefixSysIdClassMap[PREFIX_META_ID_DRIVE_SHEET] = MetaIdDriveSheet::class.java
    prefixSysIdClassMap[PREFIX_META_ID_EVENT] = MetaIdEvent::class.java
    prefixSysIdClassMap[PREFIX_META_ID_FIELD] = MetaIdField::class.java
    prefixSysIdClassMap[PREFIX_META_ID_FIELD_DYNAMIC_CONDITION] = MetaIdFieldDynamicCondition::class.java
    prefixSysIdClassMap[PREFIX_META_ID_FIELD_DYNAMIC_RULE] = MetaIdFieldDynamicRule::class.java
    prefixSysIdClassMap[PREFIX_META_ID_FOOTER] = MetaIdFooter::class.java
    prefixSysIdClassMap[PREFIX_META_ID_FORM] = MetaIdForm::class.java
    prefixSysIdClassMap[PREFIX_META_ID_FORMULA] = MetaIdFormula::class.java
    prefixSysIdClassMap[PREFIX_META_ID_FUNC_ARG] = MetaIdFuncArg::class.java
    prefixSysIdClassMap[PREFIX_META_ID_GRID] = MetaIdGrid::class.java
    prefixSysIdClassMap[PREFIX_META_ID_GROUP] = MetaIdGroup::class.java
    prefixSysIdClassMap[PREFIX_META_ID_HEADER] = MetaIdHeader::class.java
    prefixSysIdClassMap[PREFIX_META_ID_HYPERLINK] = MetaIdHyperlink::class.java
    prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_DRIVE_SHEET] = MetaIdLayoutDriveSheet::class.java
    prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_FORM] = MetaIdLayoutForm::class.java
    prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE] = MetaIdLayoutFormEditorComposite::class.java
    prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_GRID] = MetaIdLayoutGrid::class.java
    prefixSysIdClassMap[PREFIX_META_ID_LAYOUT_USER] = MetaIdLayoutUser::class.java
    prefixSysIdClassMap[PREFIX_META_ID_MAPPING] = MetaIdMapping::class.java
    prefixSysIdClassMap[PREFIX_META_ID_MODULE] = MetaIdModule::class.java
    prefixSysIdClassMap[PREFIX_META_ID_OPTION] = MetaIdOption::class.java
    prefixSysIdClassMap[PREFIX_META_ID_PARTITION] = MetaIdPartition::class.java
    prefixSysIdClassMap[PREFIX_META_ID_PAYMENT_PROVIDER] = MetaIdPaymentProvider::class.java
    prefixSysIdClassMap[PREFIX_META_ID_PIPELINE_SYSTEM] = MetaIdPipelineSystem::class.java
    prefixSysIdClassMap[PREFIX_META_ID_PIPELINE_VAR] = MetaIdPipelineVar::class.java
    prefixSysIdClassMap[PREFIX_META_ID_PLUGIN] = MetaIdPlugin::class.java
    prefixSysIdClassMap[PREFIX_META_ID_PROMPT] = MetaIdPrompt::class.java
    prefixSysIdClassMap[PREFIX_META_ID_REPORT] = MetaIdReport::class.java
    prefixSysIdClassMap[PREFIX_META_ID_ROLE] = MetaIdRole::class.java
    prefixSysIdClassMap[PREFIX_META_ID_SECTION] = MetaIdSection::class.java
    prefixSysIdClassMap[PREFIX_META_ID_SPREADSHEET] = MetaIdSpreadsheet::class.java
    prefixSysIdClassMap[PREFIX_META_ID_SPREADSHEET_REF] = MetaIdSpreadsheetRef::class.java
    prefixSysIdClassMap[PREFIX_META_ID_STEP] = MetaIdStep::class.java
    prefixSysIdClassMap[PREFIX_META_ID_SWIMLANE] = MetaIdSwimlane::class.java
    prefixSysIdClassMap[PREFIX_META_ID_TAB] = MetaIdTab::class.java
    prefixSysIdClassMap[PREFIX_META_ID_TABLE_STYLE] = MetaIdTableStyle::class.java
    prefixSysIdClassMap[PREFIX_META_ID_TRANSLATION] = MetaIdTranslation::class.java
    prefixSysIdClassMap[PREFIX_META_ID_USER_CONDITION] = MetaIdUserCondition::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VAR] = MetaIdVar::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_AUTO_DIA] = MetaIdVdAutoDia::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_AUTO_EDGE] = MetaIdVdAutoEdge::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_AUTO_FUNC] = MetaIdVdAutoFunc::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_AUTO_NODE] = MetaIdVdAutoNode::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_COMMENT] = MetaIdVdComment::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_ERD_DIA] = MetaIdVdErdDia::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_IMAGE_FUNC] = MetaIdVdImageFunc::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_NOTE] = MetaIdVdNote::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_REGION] = MetaIdVdRegion::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_REPORT_DIA] = MetaIdVdReportDia::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VD_REVIEW] = MetaIdVdReview::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VIDEO_TIMESTAMP] = MetaIdVideoTimestamp::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VISIBILITY_ACTION] = MetaIdVisibilityAction::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VISIBILITY_CONDITION] = MetaIdVisibilityCondition::class.java
    prefixSysIdClassMap[PREFIX_META_ID_VISIBILITY_RULE] = MetaIdVisibilityRule::class.java
    prefixSysIdClassMap[PREFIX_META_ID_WIZARD] = MetaIdWizard::class.java
    prefixSysIdClassMap[PREFIX_PLUGIN_API_ID] = PluginApiId::class.java
    prefixSysIdClassMap[PREFIX_PLUGIN_BUNDLE_ID] = PluginBundleId::class.java
    prefixSysIdClassMap[PREFIX_PLUGIN_ID] = PluginId::class.java
    prefixSysIdClassMap[PREFIX_PLUGIN_RESOURCE_ID] = PluginResourceId::class.java
    prefixSysIdClassMap[PREFIX_REPORT_EXECUTION_ID] = ReportExecutionId::class.java
    prefixSysIdClassMap[PREFIX_REQUEST_ID] = RequestId::class.java
    prefixSysIdClassMap[PREFIX_ROW_ID] = RowId::class.java
    prefixSysIdClassMap[PREFIX_SCHEDULER_TASK_ID] = SchedulerTaskId::class.java
    prefixSysIdClassMap[PREFIX_SHEET_ID] = SheetId::class.java
    prefixSysIdClassMap[PREFIX_SNAPSHOT_ID] = SnapshotId::class.java
    prefixSysIdClassMap[PREFIX_SPREADSHEET_PARTITION_ID] = SpreadsheetPartitionId::class.java
    prefixSysIdClassMap[PREFIX_STORE_ITEM_ID] = StoreItemId::class.java
    prefixSysIdClassMap[PREFIX_TAB_ID] = TabId::class.java
    prefixSysIdClassMap[PREFIX_TRANSACTION_ID] = TransactionId::class.java
    prefixSysIdClassMap[PREFIX_USER_ID] = UserId::class.java
    prefixSysIdClassMap[PREFIX_WORKFLOW_EXECUTION_ID] = WorkflowExecutionId::class.java
    prefixSysIdClassMap[PREFIX_WORKFLOW_GROUP_EXECUTION_ID] = WorkflowGroupExecutionId::class.java

    sysIdClassPrefixMap[AdminId::class.java] = PREFIX_ADMIN_ID
    sysIdClassPrefixMap[AutomationExecutionId::class.java] = PREFIX_AUTOMATION_EXECUTION_ID
    sysIdClassPrefixMap[ConnId::class.java] = PREFIX_CONN_ID
    sysIdClassPrefixMap[DemoAppId::class.java] = PREFIX_DEMO_APP_ID
    sysIdClassPrefixMap[DeviceId::class.java] = PREFIX_DEVICE_ID
    sysIdClassPrefixMap[EntId::class.java] = PREFIX_ENT_ID
    sysIdClassPrefixMap[EntUserId::class.java] = PREFIX_ENT_USER_ID
    sysIdClassPrefixMap[GhostId::class.java] = PREFIX_GHOST_ID
    sysIdClassPrefixMap[GroupId::class.java] = PREFIX_GROUP_ID
    sysIdClassPrefixMap[InboxIdFollower::class.java] = PREFIX_INBOX_ID_FOLLOWER
    sysIdClassPrefixMap[InboxIdMaster::class.java] = PREFIX_INBOX_ID_MASTER
    sysIdClassPrefixMap[InboxMessageId::class.java] = PREFIX_INBOX_MESSAGE_ID
    sysIdClassPrefixMap[KeychainId::class.java] = PREFIX_KEYCHAIN_ID
    sysIdClassPrefixMap[KeychainSecretId::class.java] = PREFIX_KEYCHAIN_SECRET_ID
    sysIdClassPrefixMap[MediaIdAudio::class.java] = PREFIX_MEDIA_ID_AUDIO
    sysIdClassPrefixMap[MediaIdAvatar::class.java] = PREFIX_MEDIA_ID_AVATAR
    sysIdClassPrefixMap[MediaIdDocument::class.java] = PREFIX_MEDIA_ID_DOCUMENT
    sysIdClassPrefixMap[MediaIdImage::class.java] = PREFIX_MEDIA_ID_IMAGE
    sysIdClassPrefixMap[MediaIdJar::class.java] = PREFIX_MEDIA_ID_JAR
    sysIdClassPrefixMap[MediaIdSticker::class.java] = PREFIX_MEDIA_ID_STICKER
    sysIdClassPrefixMap[MediaIdThumbnail::class.java] = PREFIX_MEDIA_ID_THUMBNAIL
    sysIdClassPrefixMap[MediaIdVideo::class.java] = PREFIX_MEDIA_ID_VIDEO
    sysIdClassPrefixMap[MediaIdVoice::class.java] = PREFIX_MEDIA_ID_VOICE
    sysIdClassPrefixMap[MessageId::class.java] = PREFIX_MESSAGE_ID
    sysIdClassPrefixMap[MetaIdAction::class.java] = PREFIX_META_ID_ACTION
    sysIdClassPrefixMap[MetaIdAutomation::class.java] = PREFIX_META_ID_AUTOMATION
    sysIdClassPrefixMap[MetaIdChartXAxis::class.java] = PREFIX_META_ID_CHART_X_AXIS
    sysIdClassPrefixMap[MetaIdChartYAxis::class.java] = PREFIX_META_ID_CHART_Y_AXIS
    sysIdClassPrefixMap[MetaIdCode::class.java] = PREFIX_META_ID_CODE
    sysIdClassPrefixMap[MetaIdCondition::class.java] = PREFIX_META_ID_CONDITION
    sysIdClassPrefixMap[MetaIdDeeplink::class.java] = PREFIX_META_ID_DEEPLINK
    sysIdClassPrefixMap[MetaIdDriveSheet::class.java] = PREFIX_META_ID_DRIVE_SHEET
    sysIdClassPrefixMap[MetaIdEvent::class.java] = PREFIX_META_ID_EVENT
    sysIdClassPrefixMap[MetaIdField::class.java] = PREFIX_META_ID_FIELD
    sysIdClassPrefixMap[MetaIdFieldDynamicCondition::class.java] = PREFIX_META_ID_FIELD_DYNAMIC_CONDITION
    sysIdClassPrefixMap[MetaIdFieldDynamicRule::class.java] = PREFIX_META_ID_FIELD_DYNAMIC_RULE
    sysIdClassPrefixMap[MetaIdFooter::class.java] = PREFIX_META_ID_FOOTER
    sysIdClassPrefixMap[MetaIdForm::class.java] = PREFIX_META_ID_FORM
    sysIdClassPrefixMap[MetaIdFormula::class.java] = PREFIX_META_ID_FORMULA
    sysIdClassPrefixMap[MetaIdFuncArg::class.java] = PREFIX_META_ID_FUNC_ARG
    sysIdClassPrefixMap[MetaIdGrid::class.java] = PREFIX_META_ID_GRID
    sysIdClassPrefixMap[MetaIdGroup::class.java] = PREFIX_META_ID_GROUP
    sysIdClassPrefixMap[MetaIdHeader::class.java] = PREFIX_META_ID_HEADER
    sysIdClassPrefixMap[MetaIdHyperlink::class.java] = PREFIX_META_ID_HYPERLINK
    sysIdClassPrefixMap[MetaIdLayoutDriveSheet::class.java] = PREFIX_META_ID_LAYOUT_DRIVE_SHEET
    sysIdClassPrefixMap[MetaIdLayoutForm::class.java] = PREFIX_META_ID_LAYOUT_FORM
    sysIdClassPrefixMap[MetaIdLayoutFormEditorComposite::class.java] = PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE
    sysIdClassPrefixMap[MetaIdLayoutGrid::class.java] = PREFIX_META_ID_LAYOUT_GRID
    sysIdClassPrefixMap[MetaIdLayoutUser::class.java] = PREFIX_META_ID_LAYOUT_USER
    sysIdClassPrefixMap[MetaIdMapping::class.java] = PREFIX_META_ID_MAPPING
    sysIdClassPrefixMap[MetaIdModule::class.java] = PREFIX_META_ID_MODULE
    sysIdClassPrefixMap[MetaIdOption::class.java] = PREFIX_META_ID_OPTION
    sysIdClassPrefixMap[MetaIdPartition::class.java] = PREFIX_META_ID_PARTITION
    sysIdClassPrefixMap[MetaIdPaymentProvider::class.java] = PREFIX_META_ID_PAYMENT_PROVIDER
    sysIdClassPrefixMap[MetaIdPipelineSystem::class.java] = PREFIX_META_ID_PIPELINE_SYSTEM
    sysIdClassPrefixMap[MetaIdPipelineVar::class.java] = PREFIX_META_ID_PIPELINE_VAR
    sysIdClassPrefixMap[MetaIdPlugin::class.java] = PREFIX_META_ID_PLUGIN
    sysIdClassPrefixMap[MetaIdPrompt::class.java] = PREFIX_META_ID_PROMPT
    sysIdClassPrefixMap[MetaIdReport::class.java] = PREFIX_META_ID_REPORT
    sysIdClassPrefixMap[MetaIdRole::class.java] = PREFIX_META_ID_ROLE
    sysIdClassPrefixMap[MetaIdSection::class.java] = PREFIX_META_ID_SECTION
    sysIdClassPrefixMap[MetaIdSpreadsheet::class.java] = PREFIX_META_ID_SPREADSHEET
    sysIdClassPrefixMap[MetaIdSpreadsheetRef::class.java] = PREFIX_META_ID_SPREADSHEET_REF
    sysIdClassPrefixMap[MetaIdStep::class.java] = PREFIX_META_ID_STEP
    sysIdClassPrefixMap[MetaIdSwimlane::class.java] = PREFIX_META_ID_SWIMLANE
    sysIdClassPrefixMap[MetaIdTab::class.java] = PREFIX_META_ID_TAB
    sysIdClassPrefixMap[MetaIdTableStyle::class.java] = PREFIX_META_ID_TABLE_STYLE
    sysIdClassPrefixMap[MetaIdTranslation::class.java] = PREFIX_META_ID_TRANSLATION
    sysIdClassPrefixMap[MetaIdUserCondition::class.java] = PREFIX_META_ID_USER_CONDITION
    sysIdClassPrefixMap[MetaIdVar::class.java] = PREFIX_META_ID_VAR
    sysIdClassPrefixMap[MetaIdVdAutoDia::class.java] = PREFIX_META_ID_VD_AUTO_DIA
    sysIdClassPrefixMap[MetaIdVdAutoEdge::class.java] = PREFIX_META_ID_VD_AUTO_EDGE
    sysIdClassPrefixMap[MetaIdVdAutoFunc::class.java] = PREFIX_META_ID_VD_AUTO_FUNC
    sysIdClassPrefixMap[MetaIdVdAutoNode::class.java] = PREFIX_META_ID_VD_AUTO_NODE
    sysIdClassPrefixMap[MetaIdVdComment::class.java] = PREFIX_META_ID_VD_COMMENT
    sysIdClassPrefixMap[MetaIdVdErdDia::class.java] = PREFIX_META_ID_VD_ERD_DIA
    sysIdClassPrefixMap[MetaIdVdImageFunc::class.java] = PREFIX_META_ID_VD_IMAGE_FUNC
    sysIdClassPrefixMap[MetaIdVdNote::class.java] = PREFIX_META_ID_VD_NOTE
    sysIdClassPrefixMap[MetaIdVdRegion::class.java] = PREFIX_META_ID_VD_REGION
    sysIdClassPrefixMap[MetaIdVdReportDia::class.java] = PREFIX_META_ID_VD_REPORT_DIA
    sysIdClassPrefixMap[MetaIdVdReview::class.java] = PREFIX_META_ID_VD_REVIEW
    sysIdClassPrefixMap[MetaIdVideoTimestamp::class.java] = PREFIX_META_ID_VIDEO_TIMESTAMP
    sysIdClassPrefixMap[MetaIdVisibilityAction::class.java] = PREFIX_META_ID_VISIBILITY_ACTION
    sysIdClassPrefixMap[MetaIdVisibilityCondition::class.java] = PREFIX_META_ID_VISIBILITY_CONDITION
    sysIdClassPrefixMap[MetaIdVisibilityRule::class.java] = PREFIX_META_ID_VISIBILITY_RULE
    sysIdClassPrefixMap[MetaIdWizard::class.java] = PREFIX_META_ID_WIZARD
    sysIdClassPrefixMap[PluginApiId::class.java] = PREFIX_PLUGIN_API_ID
    sysIdClassPrefixMap[PluginBundleId::class.java] = PREFIX_PLUGIN_BUNDLE_ID
    sysIdClassPrefixMap[PluginId::class.java] = PREFIX_PLUGIN_ID
    sysIdClassPrefixMap[PluginResourceId::class.java] = PREFIX_PLUGIN_RESOURCE_ID
    sysIdClassPrefixMap[ReportExecutionId::class.java] = PREFIX_REPORT_EXECUTION_ID
    sysIdClassPrefixMap[RequestId::class.java] = PREFIX_REQUEST_ID
    sysIdClassPrefixMap[RowId::class.java] = PREFIX_ROW_ID
    sysIdClassPrefixMap[SchedulerTaskId::class.java] = PREFIX_SCHEDULER_TASK_ID
    sysIdClassPrefixMap[SheetId::class.java] = PREFIX_SHEET_ID
    sysIdClassPrefixMap[SnapshotId::class.java] = PREFIX_SNAPSHOT_ID
    sysIdClassPrefixMap[SpreadsheetPartitionId::class.java] = PREFIX_SPREADSHEET_PARTITION_ID
    sysIdClassPrefixMap[StoreItemId::class.java] = PREFIX_STORE_ITEM_ID
    sysIdClassPrefixMap[TabId::class.java] = PREFIX_TAB_ID
    sysIdClassPrefixMap[TransactionId::class.java] = PREFIX_TRANSACTION_ID
    sysIdClassPrefixMap[UserId::class.java] = PREFIX_USER_ID
    sysIdClassPrefixMap[WorkflowExecutionId::class.java] = PREFIX_WORKFLOW_EXECUTION_ID
    sysIdClassPrefixMap[WorkflowGroupExecutionId::class.java] = PREFIX_WORKFLOW_GROUP_EXECUTION_ID
  }

  fun getSysIdClass(prefix: String): Class<out SysId>?
  {
    return prefixSysIdClassMap[prefix]
  }

  fun getSysIdPrefix(sysIdClass: Class<out SysId>): String?
  {
    return sysIdClassPrefixMap[sysIdClass]
  }
}