// neome.ai API - do not change
//

package com.neome.api.meta.base;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({
  "unused",
  "ClassTooDeepInInheritanceTree"
})
public class Types
{
  public static final int AVATAR_CROP_QUALITY = 1;
  public static final double AVATAR_MAX_MB = 1.5;
  public static final int AVATAR_SIZE_MAX = 640;
  public static final int AVATAR_SIZE_MIN = 192;
  public static final int GRID_MAX_COUNT = 20;
  public static final int PARAGRAPH_MAX_SIZE = 10240;
  public static final String PREFIX_ADMIN_ID = "ea";
  public static final String PREFIX_AUTOMATION_EXECUTION_ID = "ae";
  public static final String PREFIX_CONN_ID = "conn";
  public static final String PREFIX_DEMO_APP_ID = "dt";
  public static final String PREFIX_DEVICE_ID = "d";
  public static final String PREFIX_ENT_ID = "e";
  public static final String PREFIX_ENT_USER_ID = "eu";
  public static final String PREFIX_GHOST_ID = "gh";
  public static final String PREFIX_GROUP_ID = "g";
  public static final String PREFIX_INBOX_ID_FOLLOWER = "ii";
  public static final String PREFIX_INBOX_ID_MASTER = "im";
  public static final String PREFIX_INBOX_MESSAGE_ID = "imm";
  public static final String PREFIX_KEYCHAIN_ID = "k";
  public static final String PREFIX_KEYCHAIN_SECRET_ID = "ks";
  public static final String PREFIX_MEDIA_ID_AUDIO = "ma";
  public static final String PREFIX_MEDIA_ID_AVATAR = "mp";
  public static final String PREFIX_MEDIA_ID_DOCUMENT = "md";
  public static final String PREFIX_MEDIA_ID_IMAGE = "mi";
  public static final String PREFIX_MEDIA_ID_JAR = "mj";
  public static final String PREFIX_MEDIA_ID_STICKER = "ms";
  public static final String PREFIX_MEDIA_ID_THUMBNAIL = "mt";
  public static final String PREFIX_MEDIA_ID_VIDEO = "mv";
  public static final String PREFIX_MEDIA_ID_VOICE = "mo";
  public static final String PREFIX_MESSAGE_ID = "m";
  public static final String PREFIX_META_ID_ACTION = "mac";
  public static final String PREFIX_META_ID_AUTOMATION = "mau";
  public static final String PREFIX_META_ID_CHART_X_AXIS = "mcx";
  public static final String PREFIX_META_ID_CHART_Y_AXIS = "mcy";
  public static final String PREFIX_META_ID_CODE = "mc";
  public static final String PREFIX_META_ID_CONDITION = "mcn";
  public static final String PREFIX_META_ID_DEEPLINK = "mdl";
  public static final String PREFIX_META_ID_DRIVE_SHEET = "mds";
  public static final String PREFIX_META_ID_EVENT = "mev";
  public static final String PREFIX_META_ID_FIELD = "mfd";
  public static final String PREFIX_META_ID_FIELD_DYNAMIC_CONDITION = "mfc";
  public static final String PREFIX_META_ID_FIELD_DYNAMIC_RULE = "mfr";
  public static final String PREFIX_META_ID_FOOTER = "mft";
  public static final String PREFIX_META_ID_FORM = "mf";
  public static final String PREFIX_META_ID_FORMULA = "mfm";
  public static final String PREFIX_META_ID_FUNC_ARG = "mfa";
  public static final String PREFIX_META_ID_GRID = "mgr";
  public static final String PREFIX_META_ID_GROUP = "mgp";
  public static final String PREFIX_META_ID_HEADER = "mhd";
  public static final String PREFIX_META_ID_HYPERLINK = "mhl";
  public static final String PREFIX_META_ID_LAYOUT_DRIVE_SHEET = "mld";
  public static final String PREFIX_META_ID_LAYOUT_FORM = "mlf";
  public static final String PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE = "mle";
  public static final String PREFIX_META_ID_LAYOUT_GRID = "mlg";
  public static final String PREFIX_META_ID_LAYOUT_USER = "mlu";
  public static final String PREFIX_META_ID_MAPPING = "mg";
  public static final String PREFIX_META_ID_MODULE = "mm";
  public static final String PREFIX_META_ID_OPTION = "mop";
  public static final String PREFIX_META_ID_PARTITION = "mpt";
  public static final String PREFIX_META_ID_PAYMENT_PROVIDER = "mpp";
  public static final String PREFIX_META_ID_PIPELINE_SYSTEM = "mps";
  public static final String PREFIX_META_ID_PIPELINE_VAR = "mpv";
  public static final String PREFIX_META_ID_PLUGIN = "mpl";
  public static final String PREFIX_META_ID_PROMPT = "mpm";
  public static final String PREFIX_META_ID_REPORT = "mrp";
  public static final String PREFIX_META_ID_ROLE = "mr";
  public static final String PREFIX_META_ID_SECTION = "msc";
  public static final String PREFIX_META_ID_SPREADSHEET = "mss";
  public static final String PREFIX_META_ID_SPREADSHEET_REF = "msr";
  public static final String PREFIX_META_ID_STEP = "mst";
  public static final String PREFIX_META_ID_SWIMLANE = "msw";
  public static final String PREFIX_META_ID_TAB = "mtb";
  public static final String PREFIX_META_ID_TABLE_STYLE = "mts";
  public static final String PREFIX_META_ID_TRANSLATION = "mtl";
  public static final String PREFIX_META_ID_USER_CONDITION = "muc";
  public static final String PREFIX_META_ID_VAR = "mw";
  public static final String PREFIX_META_ID_VD_AUTO_DIA = "va";
  public static final String PREFIX_META_ID_VD_AUTO_EDGE = "vae";
  public static final String PREFIX_META_ID_VD_AUTO_FUNC = "vaf";
  public static final String PREFIX_META_ID_VD_AUTO_NODE = "van";
  public static final String PREFIX_META_ID_VD_COMMENT = "vc";
  public static final String PREFIX_META_ID_VD_ERD_DIA = "ve";
  public static final String PREFIX_META_ID_VD_IMAGE_FUNC = "vif";
  public static final String PREFIX_META_ID_VD_NOTE = "vn";
  public static final String PREFIX_META_ID_VD_REGION = "vrg";
  public static final String PREFIX_META_ID_VD_REPORT_DIA = "vr";
  public static final String PREFIX_META_ID_VD_REVIEW = "vrv";
  public static final String PREFIX_META_ID_VIDEO_TIMESTAMP = "mvt";
  public static final String PREFIX_META_ID_VISIBILITY_ACTION = "mva";
  public static final String PREFIX_META_ID_VISIBILITY_CONDITION = "mvc";
  public static final String PREFIX_META_ID_VISIBILITY_RULE = "mvr";
  public static final String PREFIX_META_ID_WIZARD = "mwz";
  public static final String PREFIX_PLUGIN_API_ID = "pa";
  public static final String PREFIX_PLUGIN_BUNDLE_ID = "pb";
  public static final String PREFIX_PLUGIN_ID = "p";
  public static final String PREFIX_PLUGIN_RESOURCE_ID = "pr";
  public static final String PREFIX_REPORT_EXECUTION_ID = "re";
  public static final String PREFIX_REQUEST_ID = "req";
  public static final String PREFIX_ROW_ID = "r";
  public static final String PREFIX_SCHEDULER_TASK_ID = "st";
  public static final String PREFIX_SHEET_ID = "s";
  public static final String PREFIX_SNAPSHOT_ID = "ss";
  public static final String PREFIX_SPREADSHEET_PARTITION_ID = "sp";
  public static final String PREFIX_STORE_ITEM_ID = "si";
  public static final String PREFIX_TAB_ID = "t";
  public static final String PREFIX_TRANSACTION_ID = "tr";
  public static final String PREFIX_USER_ID = "u";
  public static final String PREFIX_WORKFLOW_EXECUTION_ID = "we";
  public static final String PREFIX_WORKFLOW_GROUP_EXECUTION_ID = "wg";
  public static final int SCRIPT_MAX_SIZE = 20480;
  public static final String SUFFIX_TEMPLATE = ".template";
  public static final double THUMBNAIL_MAX_MB = 0.25;
  public static final int THUMBNAIL_SIZE = 144;
  private static final Map<String, Class<? extends SysId>> prefixSysIdClassMap = new HashMap<>();
  private static final Map<Class<? extends SysId>, String> sysIdClassPrefixMap = new HashMap<>();

  static
  {
    prefixSysIdClassMap.put(PREFIX_ADMIN_ID, AdminId.class);
    prefixSysIdClassMap.put(PREFIX_AUTOMATION_EXECUTION_ID, AutomationExecutionId.class);
    prefixSysIdClassMap.put(PREFIX_CONN_ID, ConnId.class);
    prefixSysIdClassMap.put(PREFIX_DEMO_APP_ID, DemoAppId.class);
    prefixSysIdClassMap.put(PREFIX_DEVICE_ID, DeviceId.class);
    prefixSysIdClassMap.put(PREFIX_ENT_ID, EntId.class);
    prefixSysIdClassMap.put(PREFIX_ENT_USER_ID, EntUserId.class);
    prefixSysIdClassMap.put(PREFIX_GHOST_ID, GhostId.class);
    prefixSysIdClassMap.put(PREFIX_GROUP_ID, GroupId.class);
    prefixSysIdClassMap.put(PREFIX_INBOX_ID_FOLLOWER, InboxIdFollower.class);
    prefixSysIdClassMap.put(PREFIX_INBOX_ID_MASTER, InboxIdMaster.class);
    prefixSysIdClassMap.put(PREFIX_INBOX_MESSAGE_ID, InboxMessageId.class);
    prefixSysIdClassMap.put(PREFIX_KEYCHAIN_ID, KeychainId.class);
    prefixSysIdClassMap.put(PREFIX_KEYCHAIN_SECRET_ID, KeychainSecretId.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_AUDIO, MediaIdAudio.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_AVATAR, MediaIdAvatar.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_DOCUMENT, MediaIdDocument.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_IMAGE, MediaIdImage.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_JAR, MediaIdJar.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_STICKER, MediaIdSticker.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_THUMBNAIL, MediaIdThumbnail.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_VIDEO, MediaIdVideo.class);
    prefixSysIdClassMap.put(PREFIX_MEDIA_ID_VOICE, MediaIdVoice.class);
    prefixSysIdClassMap.put(PREFIX_MESSAGE_ID, MessageId.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_ACTION, MetaIdAction.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_AUTOMATION, MetaIdAutomation.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_CHART_X_AXIS, MetaIdChartXAxis.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_CHART_Y_AXIS, MetaIdChartYAxis.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_CODE, MetaIdCode.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_CONDITION, MetaIdCondition.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_DEEPLINK, MetaIdDeeplink.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_DRIVE_SHEET, MetaIdDriveSheet.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_EVENT, MetaIdEvent.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_FIELD, MetaIdField.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_FIELD_DYNAMIC_CONDITION,
      MetaIdFieldDynamicCondition.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_FIELD_DYNAMIC_RULE, MetaIdFieldDynamicRule.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_FOOTER, MetaIdFooter.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_FORM, MetaIdForm.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_FORMULA, MetaIdFormula.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_FUNC_ARG, MetaIdFuncArg.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_GRID, MetaIdGrid.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_GROUP, MetaIdGroup.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_HEADER, MetaIdHeader.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_HYPERLINK, MetaIdHyperlink.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_LAYOUT_DRIVE_SHEET, MetaIdLayoutDriveSheet.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_LAYOUT_FORM, MetaIdLayoutForm.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE,
      MetaIdLayoutFormEditorComposite.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_LAYOUT_GRID, MetaIdLayoutGrid.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_LAYOUT_USER, MetaIdLayoutUser.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_MAPPING, MetaIdMapping.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_MODULE, MetaIdModule.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_OPTION, MetaIdOption.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_PARTITION, MetaIdPartition.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_PAYMENT_PROVIDER, MetaIdPaymentProvider.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_PIPELINE_SYSTEM, MetaIdPipelineSystem.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_PIPELINE_VAR, MetaIdPipelineVar.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_PLUGIN, MetaIdPlugin.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_PROMPT, MetaIdPrompt.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_REPORT, MetaIdReport.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_ROLE, MetaIdRole.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_SECTION, MetaIdSection.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_SPREADSHEET, MetaIdSpreadsheet.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_SPREADSHEET_REF, MetaIdSpreadsheetRef.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_STEP, MetaIdStep.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_SWIMLANE, MetaIdSwimlane.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_TAB, MetaIdTab.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_TABLE_STYLE, MetaIdTableStyle.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_TRANSLATION, MetaIdTranslation.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_USER_CONDITION, MetaIdUserCondition.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VAR, MetaIdVar.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_AUTO_DIA, MetaIdVdAutoDia.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_AUTO_EDGE, MetaIdVdAutoEdge.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_AUTO_FUNC, MetaIdVdAutoFunc.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_AUTO_NODE, MetaIdVdAutoNode.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_COMMENT, MetaIdVdComment.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_ERD_DIA, MetaIdVdErdDia.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_IMAGE_FUNC, MetaIdVdImageFunc.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_NOTE, MetaIdVdNote.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_REGION, MetaIdVdRegion.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_REPORT_DIA, MetaIdVdReportDia.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VD_REVIEW, MetaIdVdReview.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VIDEO_TIMESTAMP, MetaIdVideoTimestamp.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VISIBILITY_ACTION, MetaIdVisibilityAction.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VISIBILITY_CONDITION, MetaIdVisibilityCondition.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_VISIBILITY_RULE, MetaIdVisibilityRule.class);
    prefixSysIdClassMap.put(PREFIX_META_ID_WIZARD, MetaIdWizard.class);
    prefixSysIdClassMap.put(PREFIX_PLUGIN_API_ID, PluginApiId.class);
    prefixSysIdClassMap.put(PREFIX_PLUGIN_BUNDLE_ID, PluginBundleId.class);
    prefixSysIdClassMap.put(PREFIX_PLUGIN_ID, PluginId.class);
    prefixSysIdClassMap.put(PREFIX_PLUGIN_RESOURCE_ID, PluginResourceId.class);
    prefixSysIdClassMap.put(PREFIX_REPORT_EXECUTION_ID, ReportExecutionId.class);
    prefixSysIdClassMap.put(PREFIX_REQUEST_ID, RequestId.class);
    prefixSysIdClassMap.put(PREFIX_ROW_ID, RowId.class);
    prefixSysIdClassMap.put(PREFIX_SCHEDULER_TASK_ID, SchedulerTaskId.class);
    prefixSysIdClassMap.put(PREFIX_SHEET_ID, SheetId.class);
    prefixSysIdClassMap.put(PREFIX_SNAPSHOT_ID, SnapshotId.class);
    prefixSysIdClassMap.put(PREFIX_SPREADSHEET_PARTITION_ID, SpreadsheetPartitionId.class);
    prefixSysIdClassMap.put(PREFIX_STORE_ITEM_ID, StoreItemId.class);
    prefixSysIdClassMap.put(PREFIX_TAB_ID, TabId.class);
    prefixSysIdClassMap.put(PREFIX_TRANSACTION_ID, TransactionId.class);
    prefixSysIdClassMap.put(PREFIX_USER_ID, UserId.class);
    prefixSysIdClassMap.put(PREFIX_WORKFLOW_EXECUTION_ID, WorkflowExecutionId.class);
    prefixSysIdClassMap.put(PREFIX_WORKFLOW_GROUP_EXECUTION_ID, WorkflowGroupExecutionId.class);

    sysIdClassPrefixMap.put(AdminId.class, PREFIX_ADMIN_ID);
    sysIdClassPrefixMap.put(AutomationExecutionId.class, PREFIX_AUTOMATION_EXECUTION_ID);
    sysIdClassPrefixMap.put(ConnId.class, PREFIX_CONN_ID);
    sysIdClassPrefixMap.put(DemoAppId.class, PREFIX_DEMO_APP_ID);
    sysIdClassPrefixMap.put(DeviceId.class, PREFIX_DEVICE_ID);
    sysIdClassPrefixMap.put(EntId.class, PREFIX_ENT_ID);
    sysIdClassPrefixMap.put(EntUserId.class, PREFIX_ENT_USER_ID);
    sysIdClassPrefixMap.put(GhostId.class, PREFIX_GHOST_ID);
    sysIdClassPrefixMap.put(GroupId.class, PREFIX_GROUP_ID);
    sysIdClassPrefixMap.put(InboxIdFollower.class, PREFIX_INBOX_ID_FOLLOWER);
    sysIdClassPrefixMap.put(InboxIdMaster.class, PREFIX_INBOX_ID_MASTER);
    sysIdClassPrefixMap.put(InboxMessageId.class, PREFIX_INBOX_MESSAGE_ID);
    sysIdClassPrefixMap.put(KeychainId.class, PREFIX_KEYCHAIN_ID);
    sysIdClassPrefixMap.put(KeychainSecretId.class, PREFIX_KEYCHAIN_SECRET_ID);
    sysIdClassPrefixMap.put(MediaIdAudio.class, PREFIX_MEDIA_ID_AUDIO);
    sysIdClassPrefixMap.put(MediaIdAvatar.class, PREFIX_MEDIA_ID_AVATAR);
    sysIdClassPrefixMap.put(MediaIdDocument.class, PREFIX_MEDIA_ID_DOCUMENT);
    sysIdClassPrefixMap.put(MediaIdImage.class, PREFIX_MEDIA_ID_IMAGE);
    sysIdClassPrefixMap.put(MediaIdJar.class, PREFIX_MEDIA_ID_JAR);
    sysIdClassPrefixMap.put(MediaIdSticker.class, PREFIX_MEDIA_ID_STICKER);
    sysIdClassPrefixMap.put(MediaIdThumbnail.class, PREFIX_MEDIA_ID_THUMBNAIL);
    sysIdClassPrefixMap.put(MediaIdVideo.class, PREFIX_MEDIA_ID_VIDEO);
    sysIdClassPrefixMap.put(MediaIdVoice.class, PREFIX_MEDIA_ID_VOICE);
    sysIdClassPrefixMap.put(MessageId.class, PREFIX_MESSAGE_ID);
    sysIdClassPrefixMap.put(MetaIdAction.class, PREFIX_META_ID_ACTION);
    sysIdClassPrefixMap.put(MetaIdAutomation.class, PREFIX_META_ID_AUTOMATION);
    sysIdClassPrefixMap.put(MetaIdChartXAxis.class, PREFIX_META_ID_CHART_X_AXIS);
    sysIdClassPrefixMap.put(MetaIdChartYAxis.class, PREFIX_META_ID_CHART_Y_AXIS);
    sysIdClassPrefixMap.put(MetaIdCode.class, PREFIX_META_ID_CODE);
    sysIdClassPrefixMap.put(MetaIdCondition.class, PREFIX_META_ID_CONDITION);
    sysIdClassPrefixMap.put(MetaIdDeeplink.class, PREFIX_META_ID_DEEPLINK);
    sysIdClassPrefixMap.put(MetaIdDriveSheet.class, PREFIX_META_ID_DRIVE_SHEET);
    sysIdClassPrefixMap.put(MetaIdEvent.class, PREFIX_META_ID_EVENT);
    sysIdClassPrefixMap.put(MetaIdField.class, PREFIX_META_ID_FIELD);
    sysIdClassPrefixMap.put(MetaIdFieldDynamicCondition.class,
      PREFIX_META_ID_FIELD_DYNAMIC_CONDITION);
    sysIdClassPrefixMap.put(MetaIdFieldDynamicRule.class, PREFIX_META_ID_FIELD_DYNAMIC_RULE);
    sysIdClassPrefixMap.put(MetaIdFooter.class, PREFIX_META_ID_FOOTER);
    sysIdClassPrefixMap.put(MetaIdForm.class, PREFIX_META_ID_FORM);
    sysIdClassPrefixMap.put(MetaIdFormula.class, PREFIX_META_ID_FORMULA);
    sysIdClassPrefixMap.put(MetaIdFuncArg.class, PREFIX_META_ID_FUNC_ARG);
    sysIdClassPrefixMap.put(MetaIdGrid.class, PREFIX_META_ID_GRID);
    sysIdClassPrefixMap.put(MetaIdGroup.class, PREFIX_META_ID_GROUP);
    sysIdClassPrefixMap.put(MetaIdHeader.class, PREFIX_META_ID_HEADER);
    sysIdClassPrefixMap.put(MetaIdHyperlink.class, PREFIX_META_ID_HYPERLINK);
    sysIdClassPrefixMap.put(MetaIdLayoutDriveSheet.class, PREFIX_META_ID_LAYOUT_DRIVE_SHEET);
    sysIdClassPrefixMap.put(MetaIdLayoutForm.class, PREFIX_META_ID_LAYOUT_FORM);
    sysIdClassPrefixMap.put(MetaIdLayoutFormEditorComposite.class,
      PREFIX_META_ID_LAYOUT_FORM_EDITOR_COMPOSITE);
    sysIdClassPrefixMap.put(MetaIdLayoutGrid.class, PREFIX_META_ID_LAYOUT_GRID);
    sysIdClassPrefixMap.put(MetaIdLayoutUser.class, PREFIX_META_ID_LAYOUT_USER);
    sysIdClassPrefixMap.put(MetaIdMapping.class, PREFIX_META_ID_MAPPING);
    sysIdClassPrefixMap.put(MetaIdModule.class, PREFIX_META_ID_MODULE);
    sysIdClassPrefixMap.put(MetaIdOption.class, PREFIX_META_ID_OPTION);
    sysIdClassPrefixMap.put(MetaIdPartition.class, PREFIX_META_ID_PARTITION);
    sysIdClassPrefixMap.put(MetaIdPaymentProvider.class, PREFIX_META_ID_PAYMENT_PROVIDER);
    sysIdClassPrefixMap.put(MetaIdPipelineSystem.class, PREFIX_META_ID_PIPELINE_SYSTEM);
    sysIdClassPrefixMap.put(MetaIdPipelineVar.class, PREFIX_META_ID_PIPELINE_VAR);
    sysIdClassPrefixMap.put(MetaIdPlugin.class, PREFIX_META_ID_PLUGIN);
    sysIdClassPrefixMap.put(MetaIdPrompt.class, PREFIX_META_ID_PROMPT);
    sysIdClassPrefixMap.put(MetaIdReport.class, PREFIX_META_ID_REPORT);
    sysIdClassPrefixMap.put(MetaIdRole.class, PREFIX_META_ID_ROLE);
    sysIdClassPrefixMap.put(MetaIdSection.class, PREFIX_META_ID_SECTION);
    sysIdClassPrefixMap.put(MetaIdSpreadsheet.class, PREFIX_META_ID_SPREADSHEET);
    sysIdClassPrefixMap.put(MetaIdSpreadsheetRef.class, PREFIX_META_ID_SPREADSHEET_REF);
    sysIdClassPrefixMap.put(MetaIdStep.class, PREFIX_META_ID_STEP);
    sysIdClassPrefixMap.put(MetaIdSwimlane.class, PREFIX_META_ID_SWIMLANE);
    sysIdClassPrefixMap.put(MetaIdTab.class, PREFIX_META_ID_TAB);
    sysIdClassPrefixMap.put(MetaIdTableStyle.class, PREFIX_META_ID_TABLE_STYLE);
    sysIdClassPrefixMap.put(MetaIdTranslation.class, PREFIX_META_ID_TRANSLATION);
    sysIdClassPrefixMap.put(MetaIdUserCondition.class, PREFIX_META_ID_USER_CONDITION);
    sysIdClassPrefixMap.put(MetaIdVar.class, PREFIX_META_ID_VAR);
    sysIdClassPrefixMap.put(MetaIdVdAutoDia.class, PREFIX_META_ID_VD_AUTO_DIA);
    sysIdClassPrefixMap.put(MetaIdVdAutoEdge.class, PREFIX_META_ID_VD_AUTO_EDGE);
    sysIdClassPrefixMap.put(MetaIdVdAutoFunc.class, PREFIX_META_ID_VD_AUTO_FUNC);
    sysIdClassPrefixMap.put(MetaIdVdAutoNode.class, PREFIX_META_ID_VD_AUTO_NODE);
    sysIdClassPrefixMap.put(MetaIdVdComment.class, PREFIX_META_ID_VD_COMMENT);
    sysIdClassPrefixMap.put(MetaIdVdErdDia.class, PREFIX_META_ID_VD_ERD_DIA);
    sysIdClassPrefixMap.put(MetaIdVdImageFunc.class, PREFIX_META_ID_VD_IMAGE_FUNC);
    sysIdClassPrefixMap.put(MetaIdVdNote.class, PREFIX_META_ID_VD_NOTE);
    sysIdClassPrefixMap.put(MetaIdVdRegion.class, PREFIX_META_ID_VD_REGION);
    sysIdClassPrefixMap.put(MetaIdVdReportDia.class, PREFIX_META_ID_VD_REPORT_DIA);
    sysIdClassPrefixMap.put(MetaIdVdReview.class, PREFIX_META_ID_VD_REVIEW);
    sysIdClassPrefixMap.put(MetaIdVideoTimestamp.class, PREFIX_META_ID_VIDEO_TIMESTAMP);
    sysIdClassPrefixMap.put(MetaIdVisibilityAction.class, PREFIX_META_ID_VISIBILITY_ACTION);
    sysIdClassPrefixMap.put(MetaIdVisibilityCondition.class, PREFIX_META_ID_VISIBILITY_CONDITION);
    sysIdClassPrefixMap.put(MetaIdVisibilityRule.class, PREFIX_META_ID_VISIBILITY_RULE);
    sysIdClassPrefixMap.put(MetaIdWizard.class, PREFIX_META_ID_WIZARD);
    sysIdClassPrefixMap.put(PluginApiId.class, PREFIX_PLUGIN_API_ID);
    sysIdClassPrefixMap.put(PluginBundleId.class, PREFIX_PLUGIN_BUNDLE_ID);
    sysIdClassPrefixMap.put(PluginId.class, PREFIX_PLUGIN_ID);
    sysIdClassPrefixMap.put(PluginResourceId.class, PREFIX_PLUGIN_RESOURCE_ID);
    sysIdClassPrefixMap.put(ReportExecutionId.class, PREFIX_REPORT_EXECUTION_ID);
    sysIdClassPrefixMap.put(RequestId.class, PREFIX_REQUEST_ID);
    sysIdClassPrefixMap.put(RowId.class, PREFIX_ROW_ID);
    sysIdClassPrefixMap.put(SchedulerTaskId.class, PREFIX_SCHEDULER_TASK_ID);
    sysIdClassPrefixMap.put(SheetId.class, PREFIX_SHEET_ID);
    sysIdClassPrefixMap.put(SnapshotId.class, PREFIX_SNAPSHOT_ID);
    sysIdClassPrefixMap.put(SpreadsheetPartitionId.class, PREFIX_SPREADSHEET_PARTITION_ID);
    sysIdClassPrefixMap.put(StoreItemId.class, PREFIX_STORE_ITEM_ID);
    sysIdClassPrefixMap.put(TabId.class, PREFIX_TAB_ID);
    sysIdClassPrefixMap.put(TransactionId.class, PREFIX_TRANSACTION_ID);
    sysIdClassPrefixMap.put(UserId.class, PREFIX_USER_ID);
    sysIdClassPrefixMap.put(WorkflowExecutionId.class, PREFIX_WORKFLOW_EXECUTION_ID);
    sysIdClassPrefixMap.put(WorkflowGroupExecutionId.class, PREFIX_WORKFLOW_GROUP_EXECUTION_ID);
  }

  public static Class<? extends SysId> getSysIdClass(String prefix)
  {
    return prefixSysIdClassMap.get(prefix);
  }

  public static String getSysIdPrefix(Class<? extends SysId> sysIdClass)
  {
    return sysIdClassPrefixMap.get(sysIdClass);
  }
  public enum ServiceName
  {
    agent,
    ai,
    api,
    aside,
    base,
    cli,
    cluster,
    deeplink,
    doc,
    drawer,
    ent,
    entAside,
    entDrawer,
    entMain,
    extn,
    main,
    otp,
    rpc,
    scheduler,
    session,
    stem,
    store,
    studioDrawer,
    studioEnt,
    studioMain,
    task,
    user,
    wsoc
  }
  public enum DtoLogTreeKeyValueType
  {
    neoQL,
    json,
    javascript,
    xml,
    regular
  }
  public enum EnumContactCopyField
  {
    firstName,
    lastName,
    fullName,
    mobileNumber,
    email,
    address,
    birthDate
  }
  public enum EnumDefnAdminDoNotOptionEnt
  {
    actions,
    adminPermissions,
    admins,
    backend,
    debug,
    debugApiBrowser,
    debugAutomation,
    debugLogs,
    debugQuery,
    debugWorkflow,
    deeplinks,
    deploy,
    deployInfo,
    deployPayment,
    deployPlugins,
    deployVariables,
    driveSheets,
    extensions,
    facets,
    forms,
    formulas,
    frontend,
    groups,
    layouts,
    manage,
    manageDashboard,
    manageKeychain,
    managePayment,
    manageSettings,
    menus,
    modules,
    permissions,
    plugins,
    reports,
    roles,
    spreadsheets,
    theme,
    tools,
    toolsDemoApp,
    toolsWidgetWizard,
    translations,
    users,
    variables,
    visibilityRules,
    workflows
  }
  public enum EnumDefnAdminDoNotOptionPlugin
  {
    admins
  }
  public enum EnumDefnAdminDoNotOptionStoreItem
  {
    admins
  }
  public enum EnumDefnAdminPermissionType
  {
    doNotEdit,
    doNotShow
  }
  public enum EnumDefnArgBinder
  {
    argument,
    context,
    derived,
    field,
    input,
    output,
    spreadsheet,
    sep,
    variable,
    constant,
    response,
    refTarget,
    parameter
  }
  public enum EnumDefnArgBinderArgument
  {
    selectedSectionId,
    selectedGridId,
    selectedCompositeId,
    selectedGridRowId
  }
  public enum EnumDefnArgBinderContext
  {
    caller,
    callerSetting,
    ent,
    form,
    plugin,
    pluginConfig,
    row
  }
  public enum EnumDefnArgBinderContextCaller
  {
    color,
    entUserId,
    handle,
    managerId,
    assistantIds,
    allAssistantIds,
    allManagerIds,
    grandManagerId,
    nickName,
    userId,
    email,
    mobileNumber,
    roles
  }
  public enum EnumDefnArgBinderContextEnt
  {
    about,
    id,
    name,
    timeZone,
    displayDateFormat,
    systemEntUserId
  }
  public enum EnumDefnArgBinderContextForm
  {
    id,
    name,
    label
  }
  public enum EnumDefnArgBinderContextPlugin
  {
    about,
    id,
    name
  }
  public enum EnumDefnArgBinderContextRow
  {
    createdBy,
    createdOn,
    id,
    order,
    parentId,
    type,
    updatedBy,
    updatedOn
  }
  public enum EnumDefnAudioFormat
  {
    ogg,
    mp3,
    wav
  }
  public enum EnumDefnAutomationSource
  {
    currentForm,
    currentGrid
  }
  public enum EnumDefnAutomationTerminateKind
  {
    terminate,
    resume,
    setField
  }
  public enum EnumDefnAutomationWebhookKind
  {
    location,
    neomeComment,
    neomeUserSession,
    razorpayPaymentReceipt
  }
  public enum EnumDefnButtonTargetType
  {
    callReport,
    invokePlugin,
    saveToSpreadsheet,
    sendWhatsAppMessage,
    triggerAction,
    executeCallable,
    startLocationTracking,
    stopLocationTracking
  }
  public enum EnumDefnCalculateFormulaMode
  {
    automatic,
    manual,
    onSend
  }
  public enum EnumDefnCaptureMode
  {
    manual,
    onInsert,
    onUpdate
  }
  public enum EnumDefnCaptureValueKind
  {
    captureLocation,
    captureTime,
    captureUser
  }
  public enum EnumDefnChartRenderingMode
  {
    horizontal,
    vertical
  }
  public enum EnumDefnCodeEditorLanguage
  {
    csv,
    html,
    javascript,
    json,
    neoQL,
    sql,
    text,
    xml
  }
  public enum EnumDefnCodeType
  {
    barCode,
    qrCode
  }
  public enum EnumDefnCompType
  {
    bool,
    date,
    decimal,
    logDecimal,
    image,
    label,
    number,
    logNumber,
    paragraph,
    text,
    enumAdminDoNotOptionEnt,
    enumAdminDoNotOptionPlugin,
    enumAudioFormat,
    enumAutomationSource,
    enumCaptureValueKind,
    enumCodeEditorLanguage,
    enumConditionOperator,
    enumConjunction,
    enumDataPartitionPeriod,
    enumDate,
    enumDay,
    enumDeeplinkConstraints,
    enumDeployVar,
    enumDeviceSize,
    enumDeviceType,
    enumDocFileExt,
    enumDriveStatus,
    enumDurationUnit,
    enumEntLockBehavior,
    enumEntLockReason,
    enumFields,
    enumFuncArgs,
    enumMapPinShape,
    enumPaymentMethod,
    enumPaymentPlan,
    enumPermission,
    enumPluginApiMethod,
    enumPluginResources,
    enumPluginSecurityAccess,
    enumPromptAction,
    enumRoles,
    enumRowAuditTrail,
    enumSetupKind,
    enumUserSettingOptions,
    enumUserSettingValue,
    enumVideoFormat,
    enumVisibilityOperator,
    enumMonth,
    enumQuarter,
    enumDeeplinkExpiry,
    enumForms,
    enumLogOperationKind,
    enumCodeType,
    enumPosition,
    enumDateOccurrence,
    enumFrequencyKind,
    enumRenderingKind,
    enumInsertVariant,
    enumUpdateVariant,
    enumRemoveVariant,
    enumEmptyFieldVariant,
    enumTableLayoutStyle,
    enumUserProperty,
    enumRowProperty,
    enumStoreItem,
    enumCaptureMode,
    enumLockOperation,
    enumRefreshOn,
    enumEditorLayoutRenderingMode,
    enumFormLayoutType,
    enumSetOfUserKind,
    enumUserContext,
    enumDynamicOperator,
    enumTargetType,
    enumDriveSheetLayoutFor,
    enumDriveSheetFieldLayoutOn,
    enumTextStyle,
    enumContentAlignment,
    enumUserProps,
    enumGridRenderingMode,
    enumPaymentMethodKind,
    enumSortOrder,
    enumTextValidationPattern,
    enumSyncMode,
    enumPluginMode,
    enumMapRenderingMode,
    enumCalculateFormulaMode,
    enumEjectionPolicy,
    enumRefSetOperationKind,
    enumEntStage,
    enumFreezeAvatarKind,
    enumTableLayoutTheme,
    enumChartRenderingMode,
    enumThemeImageRenderingMode,
    enumPromptAttachmentFormat,
    enumLocationCapturingMode,
    enumArgBinderContext,
    enumArgBinder,
    enumKindAction,
    enumKindActionUIUpdate,
    enumKindAutomation,
    enumKindButton,
    enumKindDeeplink,
    enumKindFormComposite,
    enumKindHyperlink,
    enumKindImport,
    enumKindRating,
    enumKindReport,
    enumKindScheduledEvent,
    enumKindAutomationStep,
    enumKindSpreadsheetEvent,
    enumKindPluginWebhookEvent,
    enumKindWebhookEvent,
    enumKindTranslation,
    enumTerminateSetting,
    enumAutomationWebhookKind,
    enumLocationAccuracy,
    enumKindAutoEdge,
    enumKindAutoNode,
    enumLayoutCardFilterKind,
    enumLayoutGridKind,
    enumThemeButtonSize,
    enumThemeButtonVariant,
    enumThemeColor,
    enumThemeColorShade,
    enumThemeDirection,
    enumThemeDividerThickness,
    enumThemeFieldMargin,
    enumThemeFieldSize,
    enumThemeFieldVariant,
    enumThemeFormVariant,
    enumThemeImageCorner,
    enumThemePickVariant,
    enumThemePickMultiVariant,
    enumPlacement,
    enumThemeSectionVariant,
    enumThemeStroke,
    enumThemeTabVariant,
    enumVisibilityAction,
    enumVisibilityActionOn,
    enumWizardNavigationMode,
    currency,
    icon,
    language,
    timeZone,
    pinShape,
    lineStroke,
    month,
    quarter,
    textSize,
    paymentStatus,
    messageKind,
    chipSet,
    chipSetDate,
    chipSetDateTime,
    chipSetDay,
    chipSetDeviceSize,
    chipSetDeviceType,
    chipSetTime,
    pickRole,
    pickText,
    pickTree,
    pickUser,
    pickGridRow,
    pickReportRow,
    setOfRole,
    setOfUser,
    setOfText,
    color,
    hyperlink,
    audio,
    camera,
    counter,
    logCounter,
    dateRange,
    dateTime,
    dateTimeRange,
    duration,
    email,
    handle,
    location,
    mobileNumber,
    rating,
    signature,
    slider,
    time,
    video,
    voice,
    geoPoint,
    rowId,
    symbol,
    schedulerId,
    spreadsheetId,
    button,
    divider,
    document,
    error,
    html,
    identifier,
    info,
    propertyMap,
    scanCode,
    setOfDocument,
    showCode,
    userId,
    dynamic,
    hyperlinkRow,
    password,
    ref,
    refSet,
    refUser,
    refReport,
    refTarget,
    refContact,
    grid,
    section,
    spreadsheetRef,
    tab,
    wizard,
    dateFormat,
    studioVarIdTextEditor,
    studioVarIdParagraphEditor,
    studioCodeEditor,
    pickActionId,
    pickCompId,
    pickPluginCompId,
    pickFieldId,
    pickPluginFieldId,
    pickFormId,
    pickPluginFormId,
    pickGridId,
    pickImportPluginId,
    pickImportPluginApiId,
    pickLayoutFormContentId,
    pickLayoutGridId,
    pickSpreadsheetRefLayoutId,
    pickLayoutSpreadsheetId,
    pickPluginBundleId,
    pickPluginId,
    pickReportId,
    pickSectionId,
    pickSpreadsheetId,
    pickVarId,
    pickGroupId,
    pickDeeplinkId,
    pickPipelineVarId,
    pickDeployPaymentProviderId,
    pickAutomationId,
    studioBuildAllModules,
    studioBuildArgBinder,
    studioSetOfDate,
    studioBuildColor,
    studioBuildDate,
    studioBuildDateTime,
    studioBuildPermissionMatrix,
    studioBuildTree,
    studioBuildUserSetting,
    studioBuildActionPermission,
    studioBuildPropertyMap,
    studioBuildMapping,
    studioBuildVideoTimestampMap,
    studioBuildOptionPermissionMatrix,
    studioMapOfForwardRolePermission,
    studioMapOfCondition,
    studioMapOfFormula,
    studioMapOfFuncArg,
    studioMapOfJarFile,
    studioMapOfLayoutSpreadsheet,
    studioMapOfLayoutGrid,
    studioMapOfText,
    studioMapOfVisibilityCondition,
    studioMapOfVisibilityAction,
    studioMapOfPartition,
    studioMapOfForwardGroupPermission,
    studioMapOfDynamicRule,
    studioMapOfPipelineVariable,
    studioMapOfDynamicCondition,
    studioMapOfUserCondition,
    studioMapOfLayoutDriveSpreadsheet,
    studioFieldMappingTree,
    studioGridMappingTree,
    studioMapOfArgBinder,
    studioMapOfRefTargetSpreadsheet,
    studioSetOfDocFileExt,
    studioSetOfStoreItemCategory,
    studioSetOfModule,
    studioSetOfNumber,
    studioSetOfAdminDoNotOption,
    studioSetOfPluginSecurityAccess,
    studioSetOfRowAuditTrail,
    studioSetOfMonth,
    studioSetOfBorder,
    studioSetOfBorderRadius,
    studioSetOfCompId,
    studioSetOfDataExportKind,
    studioSetOfLanguageKeys,
    studioSetOfActionId,
    studioSetOfFieldId,
    studioSetOfPluginFieldId,
    studioSetOfFieldRefId,
    studioSetOfFormId,
    studioSetOfGridId,
    studioSetOfGroupId,
    studioSetOfLayoutFormContentId,
    studioSetOfLayoutGridId,
    studioSetOfLayoutSpreadsheetId,
    studioSetOfReportId,
    studioSetOfSectionId,
    studioSetOfSpreadsheetId,
    studioSetOfVarId,
    studioCompArray,
    otp,
    avtar,
    carousel,
    formList,
    formListItem,
    pickOption,
    wallpaper
  }
  public enum EnumDefnConditionOperator
  {
    hasNoValue,
    equalTo,
    greaterThan,
    greaterThanOrEqualTo,
    hasValue,
    lessThan,
    lessThanOrEqualTo,
    notEqualTo,
    contains,
    notContains
  }
  public enum EnumDefnConjunction
  {
    or,
    and
  }
  public enum EnumDefnContentAlignment
  {
    start,
    center,
    end
  }
  public enum EnumDefnDataExportKind
  {
    xlsx,
    json
  }
  public enum EnumDefnDataPartitionPeriod
  {
    daily,
    hourly,
    weekly,
    monthly,
    quarterly,
    yearly
  }
  public enum EnumDefnDate
  {
    lastQuarter,
    lastWeek,
    lastMonth,
    lastYear,
    nextQuarter,
    nextWeek,
    nextMonth,
    nextYear,
    now,
    tomorrow,
    yesterday,
    startOfWeek,
    startOfMonth,
    startOfYear,
    endOfWeek,
    endOfMonth,
    endOfYear,
    createdOn,
    updatedOn
  }
  public enum EnumDefnDateOccurrence
  {
    custom,
    first,
    last
  }
  public enum EnumDefnDay
  {
    sunday,
    monday,
    tuesday,
    wednesday,
    thursday,
    friday,
    saturday
  }
  public enum EnumDefnDeeplinkConstraint
  {
    enforceGlobalUserSignIn,
    enforceEnterpriseUserSignIn,
    makeAnEnterpriseUser,
    allowPublicSharing
  }
  public enum EnumDefnDeeplinkExpiry
  {
    onFirstClick,
    withinOneWeek,
    withinOneMonth,
    noExpiry
  }
  public enum EnumDefnDeploy
  {
    requiredOnDeploy,
    fixedOnDeploy
  }
  public enum EnumDefnDeviceSize
  {
    mobile,
    tablet,
    laptop,
    desktop
  }
  public enum EnumDefnDocFileExt
  {
    ai,
    any,
    avi,
    cdr,
    csv,
    dll,
    doc,
    docx,
    drawio,
    dwg,
    eml,
    gif,
    html,
    jar,
    jpeg,
    jpg,
    json,
    mov,
    mp3,
    mp4,
    msg,
    oga,
    ogg,
    pdf,
    png,
    ppt,
    pptx,
    rvt,
    std,
    svg,
    tiff,
    txt,
    wav,
    webm,
    xls,
    xlsx,
    xml,
    zip
  }
  public enum EnumDefnDriveSheetFieldLayoutOn
  {
    column,
    header
  }
  public enum EnumDefnDriveSheetLayoutFor
  {
    sectionOrGrid,
    field
  }
  public enum EnumDefnDriveStatus
  {
    connected,
    disconnected,
    notInstalled
  }
  public enum EnumDefnDurationUnit
  {
    seconds,
    minutes,
    hours,
    days,
    weeks,
    months,
    quarters,
    years
  }
  public enum EnumDefnDynamicOperator
  {
    hasNoValue,
    hasValue,
    equalTo,
    notEqualTo
  }
  public enum EnumDefnEditorLayoutRenderingMode
  {
    tabs,
    stack,
    wizard
  }
  public enum EnumDefnEjectionPolicy
  {
    FIFO,
    LIFO
  }
  public enum EnumDefnEmptyFieldVariant
  {
    ignoreEmptyField,
    overrideEmptyField
  }
  public enum EnumDefnEntLockBehavior
  {
    readAccess,
    zeroAccess,
    fullAccessWithWarning
  }
  public enum EnumDefnEntLockReason
  {
    blocked,
    obsolete,
    other,
    paymentNotReceived,
    tooMuchLoad,
    userUpgrade
  }
  public enum EnumDefnEntStage
  {
    Created,
    POC,
    UserInvited,
    Production
  }
  public enum EnumDefnErrorSeverity
  {
    error,
    suggestion,
    warning
  }
  public enum EnumDefnFields
  {
    $CreatedBy,
    $CreatedOn,
    $RowId,
    $RowOrder,
    $UpdatedBy,
    $UpdatedOn,
    $ParentRowId
  }
  public enum EnumDefnFormLayoutType
  {
    editor,
    content,
    template
  }
  public enum EnumDefnForms
  {
    $FormMapOfOptions,
    $FormPickTree,
    $FormSetOfUser,
    $FormPluginConfig,
    $FormSchedule,
    $FormPaymentReceipt,
    $FormUserSession,
    $FormRowComment,
    $FormLocation,
    $FormEntAdmin,
    $FormEntUser,
    $FormEntAuditRecord,
    $FormPrompt,
    $FormRagPromptResponse,
    $FormRowEditHistory,
    $FormHumanLink,
    $FormUserMembership,
    $FormCrawl,
    $FormSearch,
    $FormBotResponse,
    $FormBotHistory
  }
  public enum EnumDefnFreezeAvatarKind
  {
    rounded,
    square
  }
  public enum EnumDefnFuncArg
  {
    number,
    text,
    numberArray,
    textArray
  }
  public enum EnumDefnGridRenderingMode
  {
    auto,
    flex
  }
  public enum EnumDefnHttpMethod
  {
    delete,
    get,
    patch,
    post,
    put
  }
  public enum EnumDefnInsertVariant
  {
    insertForced,
    skipEmptyKeyField,
    doNotInsert
  }
  public enum EnumDefnKindAction
  {
    executeCallable,
    report,
    rowInsert,
    rowUpdate,
    spreadsheetEditor,
    spreadsheetHistory,
    uiUpdate,
    user
  }
  public enum EnumDefnKindActionUIUpdate
  {
    groupSwitcher
  }
  public enum EnumDefnKindAiProvider
  {
    openAI_4_1_MINI,
    openAI_5
  }
  public enum EnumDefnKindAutoEdge
  {
    ERROR,
    EXPIRY,
    FALSE,
    ITERATE,
    NEXT,
    TRUE,
    VALUE
  }
  public enum EnumDefnKindAutoNode
  {
    acquireLock,
    aiAgent,
    aiAudioToText,
    aiDocumentToForm,
    aiExcelToSpreadsheet,
    aiFakerToForm,
    aiFakerToSpreadsheet,
    aiFormToClassification,
    aiFormToForm,
    aiFormToHtml,
    aiFormToImage,
    aiFormToJSON,
    aiFormToPDF,
    aiFormToSentiment,
    aiFormToSummary,
    aiFormToXML,
    aiSpreadsheetToCSV,
    aiSpreadsheetToExcel,
    aiSpreadsheetToHTML,
    aiSpreadsheetToJSON,
    aiSpreadsheetToPDF,
    aiSpreadsheetToXML,
    aiTextToClassification,
    aiTextToForm,
    aiTextToJSON,
    aiTextToSentiment,
    aiTextToSummary,
    aiTextToXML,
    aiXMLToForm,
    aiXMLToSpreadsheet,
    applyFormula,
    applyTransforms,
    botBuildResponse,
    botHistoryAddPrompt,
    botHistoryAddResponse,
    botHistoryGet,
    botHistoryRemove,
    botHistoryToStory,
    botSendResponse,
    branchIfElse,
    branchIterateArray,
    branchIterateGrid,
    branchIterateSpreadsheet,
    branchSwitchCase,
    branchSwitchForm,
    branchSwitchPrompt,
    debugLog,
    eventChat,
    eventHumanLink,
    eventManualTrigger,
    eventPaymentReceipt,
    eventPluginWebhook,
    eventRowComment,
    eventRpcCall,
    eventSchedule,
    eventSsInsertAfter,
    eventSsInsertBefore,
    eventSsRemoveAfter,
    eventSsRemoveBefore,
    eventSsUpdateAfter,
    eventSsUpdateBefore,
    eventSubWorkflow,
    eventUserExit,
    eventUserJoin,
    eventUserLocation,
    eventUserOffline,
    eventUserOnline,
    executeAction,
    executeJavascript,
    executeParallel,
    executePlugin,
    executeReport,
    executeRpc,
    executeScheduler,
    executeSchedulerRemove,
    executeSubWorkflow,
    fieldRefSetSet,
    fieldRemove,
    fieldSet,
    generateDeeplink,
    generateImage,
    generatePaymentLink,
    generatePdf,
    imageTransforms,
    mediaExists,
    mediaRemove,
    paramCalc,
    paramClone,
    paramCreate,
    paramExist,
    paramRemove,
    paramUpdate,
    pause,
    releaseLock,
    resume,
    rowForward,
    rowGet,
    rowGetHistory,
    rowInsert,
    rowInsertPartitionRequest,
    rowRemove,
    rowSendComment,
    rowUpdate,
    rowUpdateFieldLogNumber,
    sendEmail,
    sendHumanLink,
    sendMessageToGroups,
    sendMessageToUsers,
    sendPushNotification,
    sendWhatsappMessage,
    sendWhatsappTemplate,
    ssCrawl,
    ssExecuteQuery,
    ssFtsSearch,
    ssRagSearch,
    ssRemoveRows,
    stopAndError,
    userAdd,
    userGet,
    userGetAllAssistants,
    userGetAssistants,
    userGetGrandManager,
    userGetManager,
    userHasGrandManager,
    userHasManager,
    userHasRoles,
    userIsAllAssistant,
    userIsAllManager,
    userIsAssistant,
    userIsGrandManager,
    userIsManager,
    userIterate,
    userRemove,
    userUpdate,
    validate,
    validatePrompt,
    wait
  }
  public enum EnumDefnKindAutoResponseWait
  {
    all,
    anyOne,
    none
  }
  public enum EnumDefnKindAutoXform
  {
    stringJoiner,
    stringIsMobileNumber,
    stringIsEmail
  }
  public enum EnumDefnKindAutomation
  {
    callable,
    pluginWebhook,
    scheduled,
    spreadsheet,
    webhook
  }
  public enum EnumDefnKindAutomationStep
  {
    addUser,
    updateUser,
    calculateFormulas,
    callPlugin,
    callReport,
    copyField,
    forwardToGroups,
    forwardToUsers,
    generateDeeplink,
    getSpreadsheetRow,
    getSpreadsheetRows,
    validation,
    insertIntoSpreadsheet,
    lock,
    sendMessage,
    sendMessageToUsers,
    sendMessageAsComment,
    sendMessageToGroups,
    generatePdf,
    generateImage,
    generatePaymentLink,
    sendWhatsappTemplateMessage,
    sendWhatsappDynamicMessage,
    sendEmail,
    sendPushNotification,
    partitionSend,
    pause,
    removeField,
    removeFromSpreadsheet,
    removeCurrentRow,
    removeRows,
    removeUser,
    returnEvent,
    terminate,
    updateField,
    updateFieldLogNumber,
    updateFieldRefSet,
    updateSpreadsheet,
    execute,
    executeAsync,
    clearPipeline,
    parseDocument,
    addSchedule,
    removeSchedule
  }
  public enum EnumDefnKindBranchIfElse
  {
    Condition,
    ConditionVar
  }
  public enum EnumDefnKindButton
  {
    submit,
    reset,
    refresh,
    normal
  }
  public enum EnumDefnKindCallableEvent
  {
    onFire
  }
  public enum EnumDefnKindChannelType
  {
    email,
    neome,
    slack,
    sms,
    whatsapp
  }
  public enum EnumDefnKindDeeplink
  {
    report,
    spreadsheetEditor,
    spreadsheetInsert,
    spreadsheetRow
  }
  public enum EnumDefnKindFormComposite
  {
    grid,
    section,
    spreadsheetRef
  }
  public enum EnumDefnKindHyperlink
  {
    general,
    youtube
  }
  public enum EnumDefnKindImageXform
  {
    blur
  }
  public enum EnumDefnKindImport
  {
    plugin
  }
  public enum EnumDefnKindMessage
  {
    audio,
    camera,
    document,
    image,
    linkText,
    location,
    text,
    video,
    user,
    voice
  }
  public enum EnumDefnKindNoteStatus
  {
    Done,
    Error,
    Start,
    Verify
  }
  public enum EnumDefnKindPipelineUpdate
  {
    Mapping,
    MappingVar
  }
  public enum EnumDefnKindPluginWebhookEvent
  {
    onCallback
  }
  public enum EnumDefnKindRating
  {
    heart_1,
    thumbs_2,
    star_3,
    star_4,
    star_5
  }
  public enum EnumDefnKindReport
  {
    composite,
    mapper,
    plugin,
    query,
    spreadsheet
  }
  public enum EnumDefnKindScheduledEvent
  {
    onExpiry
  }
  public enum EnumDefnKindSentiment
  {
    VeryPositive,
    Positive,
    Neutral,
    Negative,
    VeryNegative
  }
  public enum EnumDefnKindSetOfUser
  {
    roles,
    fields,
    context
  }
  public enum EnumDefnKindSpreadsheetEvent
  {
    afterInsert,
    afterRemove,
    afterUpdate,
    beforeInsert,
    beforeRemove,
    beforeUpdate
  }
  public enum EnumDefnKindTranslation
  {
    text,
    paragraph
  }
  public enum EnumDefnKindWebhookEvent
  {
    onCallback
  }
  public enum EnumDefnLayoutCardFilterKind
  {
    tree,
    tab
  }
  public enum EnumDefnLayoutGridKind
  {
    card,
    list,
    map,
    table,
    kanban,
    calendar,
    xyChartBarGraph,
    xyChartLineChart,
    xyChartPieChart,
    xyChartDoughnut,
    xyChartScatterPlot
  }
  public enum EnumDefnLayoutUserKind
  {
    hierarchy,
    tree
  }
  public enum EnumDefnLocationAccuracy
  {
    high,
    balanced,
    low
  }
  public enum EnumDefnLocationCapturingMode
  {
    scheduled,
    manual
  }
  public enum EnumDefnLockOperation
  {
    acquire,
    release
  }
  public enum EnumDefnLogOperationKind
  {
    add,
    subtract,
    set
  }
  public enum EnumDefnMapPinShape
  {
    avatar,
    avatarWithName,
    circle,
    circleBig,
    circleMedium,
    circleWithLabel,
    heart,
    heartBig,
    heartMedium,
    label,
    pin,
    pinWithLabel,
    square,
    squareBig,
    squareMedium,
    star,
    starBig,
    starMedium,
    triangle,
    triangleBig,
    triangleMedium
  }
  public enum EnumDefnMapRenderingMode
  {
    fixedLocation,
    liveLocation
  }
  public enum EnumDefnMonth
  {
    January,
    February,
    March,
    April,
    May,
    June,
    July,
    August,
    September,
    October,
    November,
    December,
    CurrentMonth,
    PreviousMonth,
    NextMonth
  }
  public enum EnumDefnNodeTerminateKind
  {
    resume,
    stopOrErrorBranch
  }
  public enum EnumDefnPaymentMethod
  {
    creditCard,
    debitCard
  }
  public enum EnumDefnPaymentMethodKind
  {
    netbanking,
    card,
    upi
  }
  public enum EnumDefnPaymentPlan
  {
    free,
    team,
    business,
    onPremise
  }

  public enum EnumDefnPaymentStatus
  {
    pending,
    paid,
    failed
  }
  public enum EnumDefnPermission
  {
    hide,
    read,
    writeOnInsert,
    writeOnce,
    invisible,
    write
  }
  public enum EnumDefnPipelineFormKind
  {
    input,
    output
  }
  public enum EnumDefnPipelineSystem
  {
    $Curr,
    $Iter,
    $Out,
    $Prev,
    $Prior,
    $Sys
  }
  public enum EnumDefnPlacement
  {
    top,
    bottom,
    start,
    end,
    center,
    diagonal,
    overlayTop,
    flexCenter,
    spaceBetween,
    justify
  }

  public enum EnumDefnPluginApiMethod
  {
    delete,
    get,
    patch,
    post,
    put,
    webhook,
    function
  }
  public enum EnumDefnPluginMode
  {
    agent,
    javascript,
    webService
  }
  public enum EnumDefnPluginResources
  {
    jar,
    rpc,
    dev
  }
  public enum EnumDefnPluginSecurityAccess
  {
    drive,
    network
  }
  public enum EnumDefnPosition
  {
    topLeft,
    topRight,
    bottomLeft,
    bottomRight
  }
  public enum EnumDefnPromptAction
  {
    insert,
    update,
    remove,
    get
  }
  public enum EnumDefnPromptAttachmentFormat
  {
    pdf,
    image
  }
  public enum EnumDefnQuarter
  {
    Quarter_1,
    Quarter_2,
    Quarter_3,
    Quarter_4
  }
  public enum EnumDefnRefSetOperationKind
  {
    set,
    union,
    intersection,
    insert,
    put,
    remove,
    moveUp,
    moveDown,
    moveTop,
    moveBottom,
    sort
  }
  public enum EnumDefnRefreshOn
  {
    refreshOnOpen,
    refreshOnSend,
    refreshOnDemand
  }
  public enum EnumDefnRemoveVariant
  {
    removeForced,
    doNotRemove
  }

  public enum EnumDefnRenderingKind
  {
    a4Size,
    custom,
    fitToScreen,
    fullScreen,
    mm_48,
    mm_58,
    mm_72,
    mm_80,
    mm_104,
    receiptSize
  }

  public enum EnumDefnRepeatFrequencyKind
  {
    minutes,
    hours,
    days,
    weeks,
    months,
    years
  }

  public enum EnumDefnRoles
  {
    $Public,
    $Manager,
    $GrandManager,
    $AllManagers,
    $Assistants,
    $AllAssistants,
    $Self
  }

  public enum EnumDefnRowAuditTrail
  {
    insert,
    update,
    remove
  }

  public enum EnumDefnRowProperty
  {
    createdBy,
    updatedBy
  }

  public enum EnumDefnScanCodeType
  {
    barCode,
    qrCode
  }

  public enum EnumDefnSetupKind
  {
    quick,
    standard,
    advanced,
    focusDeploy,
    focusBackend,
    focusFrontend
  }

  public enum EnumDefnShowBorderKind
  {
    top,
    bottom,
    left,
    right
  }

  public enum EnumDefnShowBorderRadiusKind
  {
    topLeft,
    topRight,
    bottomLeft,
    bottomRight
  }

  public enum EnumDefnSortOrder
  {
    ascending,
    descending
  }

  public enum EnumDefnStoreItem
  {
    template,
    application
  }

  public enum EnumDefnSyncMode
  {
    backup,
    biDirectional
  }

  public enum EnumDefnTableLayoutTheme
  {
    standard,
    spacious
  }

  public enum EnumDefnTableStyle
  {
    defaultStyle
  }

  public enum EnumDefnTextSize
  {
    body1,
    body2,
    button,
    caption,
    h1,
    h2,
    h3,
    h4,
    h5,
    h6,
    inherit,
    overline,
    subtitle1,
    subtitle2,
    subtitle3,
    subtitle4
  }

  public enum EnumDefnTextStyle
  {
    bold,
    italic,
    underlined,
    strikeout
  }

  public enum EnumDefnTextValidationPattern
  {
    aadhaar,
    gstin,
    pan
  }

  public enum EnumDefnThemeButtonSize
  {
    small,
    medium,
    large
  }

  public enum EnumDefnThemeButtonVariant
  {
    text,
    contained,
    outlined,
    icon
  }

  public enum EnumDefnThemeColor
  {
    transparent,
    primary,
    secondary,
    error,
    info,
    success,
    warning,
    textPrimary,
    textSecondary,
    textDisabled,
    textInverse,
    primaryLight,
    secondaryLight,
    successLight,
    errorLight,
    infoLight,
    warningLight,
    primaryDark,
    secondaryDark,
    successDark,
    errorDark,
    infoDark,
    warningDark,
    amber,
    black,
    blue,
    cyan,
    deepOrange,
    deepPurple,
    green,
    grey,
    indigo,
    lightBlue,
    lightGreen,
    lime,
    orange,
    pink,
    purple,
    red,
    teal,
    white,
    yellow
  }

  public enum EnumDefnThemeColorShade
  {
    s50,
    s100,
    s200,
    s300,
    s400,
    s500
  }

  public enum EnumDefnThemeDirection
  {
    horizontal,
    vertical
  }

  public enum EnumDefnThemeDividerKind
  {
    thick,
    thin
  }

  public enum EnumDefnThemeFieldMargin
  {
    dense,
    none,
    normal
  }

  public enum EnumDefnThemeFieldSize
  {
    medium,
    small
  }

  public enum EnumDefnThemeFieldVariant
  {
    outlined,
    filled,
    standard
  }

  public enum EnumDefnThemeFormVariant
  {
    form,
    report
  }

  public enum EnumDefnThemeImageCorner
  {
    rectangle,
    circle,
    rounded
  }

  public enum EnumDefnThemeImageRenderingMode
  {
    aspectFit,
    scaleToFit
  }

  public enum EnumDefnThemePickMultiVariant
  {
    checkboxVertical,
    checkboxHorizontal,
    dropdown
  }

  public enum EnumDefnThemePickVariant
  {
    radioButtonVertical,
    radioButtonHorizontal,
    led,
    dropdown
  }

  public enum EnumDefnThemeSectionVariant
  {
    form,
    propertyEditor
  }

  public enum EnumDefnThemeStroke
  {
    dash,
    dotted,
    solid
  }

  public enum EnumDefnThemeTabVariant
  {
    standard,
    scrollable,
    fullWidth
  }

  public enum EnumDefnTime
  {
    now
  }

  public enum EnumDefnUpdateVariant
  {
    updateForced,
    doNotUpdate
  }

  public enum EnumDefnUserContext
  {
    caller,
    createdBy,
    updatedBy
  }

  public enum EnumDefnUserProperty
  {
    nickName,
    handle
  }

  public enum EnumDefnUserProps
  {
    firstName,
    lastName,
    fullName,
    email,
    mobileNumber,
    handle
  }

  public enum EnumDefnUserSettingOptions
  {
    text,
    number,
    decimal,
    pickOne,
    pickMany
  }

  public enum EnumDefnUserSettingValue
  {
    dataEntered,
    dataNotEntered
  }

  public enum EnumDefnVideoFormat
  {
    mp4
  }

  public enum EnumDefnVisibilityAction
  {
    blink,
    click,
    clear,
    setValue,
    disable,
    enable,
    executeAction,
    hidden,
    highlight,
    invisible,
    shake,
    visible
  }

  public enum EnumDefnVisibilityActionOn
  {
    component,
    field,
    layout,
    sendButton
  }

  public enum EnumDefnVisibilityOperator
  {
    hasNoValue,
    hasValue,
    equalTo,
    notEqualTo,
    hasChanged
  }

  public enum EnumDefnWizardNavigationMode
  {
    nextButton,
    nextPreviousButton
  }

  public enum EnumDeviceType
  {
    android,
    ios,
    web,
    widget,
    agent,
    test
  }

  public enum EnumEnvValidationError
  {
    cli,
    composite,
    invalidParam,
    notAccessible,
    notChanged,
    notFound,
    ruleViolation
  }

  public enum EnumFormContentPosition
  {
    start,
    flexCenter,
    end
  }

  public enum EnumFormExportType
  {
    pdf,
    image,
    html
  }

  public enum EnumIdentityProviderKind
  {
    apple,
    google,
    microsoft
  }

  public enum EnumKeychainType
  {
    rpcReceive,
    rpcSend,
    slack
  }

  public enum EnumLogItemType
  {
    text,
    tree,
    table
  }

  public enum EnumLogTableAlignment
  {
    left,
    center,
    right
  }

  public enum EnumLogTableTextStyle
  {
    plain,
    bold,
    italic,
    underline,
    strikeThrough,
    boldItalic,
    boldUnderline,
    boldStrikeThrough
  }

  public enum EnumLogTextType
  {
    neoQL,
    cli,
    json,
    plain,
    monospaced,
    javascript,
    html,
    xml
  }

  public enum EnumLogTreeItemType
  {
    keyValue,
    line
  }

  public enum EnumLogTreeLineCollapse
  {
    showCollapse,
    showExpand,
    ignore
  }

  public enum EnumMediaType
  {
    audio,
    document,
    icon,
    image,
    jar,
    avatar,
    sticker,
    thumbnail,
    video,
    voice
  }

  public enum EnumNeatPathCaption
  {
    About,
    Plugins,
    Roles,
    Variables,
    Translations,
    Forms,
    Reports,
    Spreadsheets,
    Actions,
    Groups,
    Deeplinks,
    DriveSheets,
    Deploy,
    Automation,
    Admins,
    Users,
    Details,
    API,
    Resources,
    Store
  }

  public enum EnumPaymentProviderKind
  {
    razorpay
  }

  public enum EnumSchemaColumnType
  {
    Boolean,
    Date,
    DateArray,
    Double,
    GeoHash,
    GeoPoint,
    Long,
    String,
    StringArray,
    SysId,
    LongArray,
    SysIdArray
  }

  public enum EnumStoreItemArtifact
  {
    ent,
    plugin,
    template
  }

  public enum EnumStoreLabel
  {
    CRM,
    Demo,
    Ffreedom,
    Hubspot,
    Neome,
    Plugin,
    SalesForce,
    ServiceNow,
    Tally,
    Ticketing,
    Zendesk
  }

  public enum EnumStudioCompType
  {
    bool,
    date,
    decimal,
    logDecimal,
    image,
    label,
    number,
    logNumber,
    paragraph,
    text,
    chipSet,
    chipSetDate,
    chipSetDateTime,
    chipSetDay,
    chipSetDeviceSize,
    chipSetDeviceType,
    chipSetTime,
    currency,
    icon,
    language,
    timeZone,
    pinShape,
    lineStroke,
    paymentStatus,
    month,
    quarter,
    textSize,
    messageKind,
    pickRole,
    pickText,
    pickTree,
    pickUser,
    pickGridRow,
    pickReportRow,
    setOfRole,
    setOfUser,
    setOfText,
    color,
    hyperlink,
    audio,
    camera,
    counter,
    logCounter,
    dateRange,
    dateTime,
    dateTimeRange,
    duration,
    email,
    handle,
    location,
    mobileNumber,
    rating,
    signature,
    slider,
    time,
    video,
    voice,
    geoPoint,
    rowId,
    symbol,
    schedulerId,
    spreadsheetId,
    button,
    divider,
    document,
    error,
    html,
    identifier,
    info,
    propertyMap,
    scanCode,
    setOfDocument,
    showCode,
    userId,
    dynamic,
    hyperlinkRow,
    password,
    ref,
    refSet,
    refUser,
    refReport,
    refTarget,
    refContact,
    grid,
    section,
    spreadsheetRef
  }

  public enum EnumStudioVarKind
  {
    any,
    bool,
    buttonVariant,
    color,
    currency,
    date,
    dateTime,
    day,
    decimal,
    deviceSize,
    deviceType,
    direction,
    dividerKind,
    document,
    duration,
    email,
    textSize,
    html,
    hyperlink,
    icon,
    image,
    imageCorner,
    language,
    location,
    mapPinShape,
    mobileNumber,
    number,
    paragraph,
    ratingKind,
    stroke,
    symbol,
    text,
    placement,
    time,
    timeZone,
    month,
    quarter,
    condition,
    function,
    mapping,
    sequence,
    userSetting,
    mapOfText,
    setOfDate,
    setOfDay,
    setOfNumber,
    setOfText,
    setOfTime,
    setOfUser,
    tree
  }

  public enum EnumWhatsAppTemplateHeaderType
  {
    none,
    video,
    document,
    image
  }
  public static class AdminId extends SysId
  {
  }
  public static class ArtifactId extends SysId
  {
  }
  public static class AutomationExecutionId extends SysId
  {
  }
  public static class ChatId extends SysId
  {
  }
  public static class ConnId extends SysId
  {
  }
  public static class ContactId extends ChatId
  {
  }
  public static class DemoAppId extends SysId
  {
  }
  public static class DeviceId extends SysId
  {
  }
  public static class EntId extends ArtifactId
  {
  }
  public static class EntUserId extends ContactId
  {
  }
  public static class GhostId extends SysId
  {
  }
  public static class GroupId extends ContactId
  {
  }
  public static class InboxId extends SysId
  {
  }
  public static class InboxIdFollower extends InboxId
  {
  }
  public static class InboxIdMaster extends InboxId
  {
  }
  public static class InboxMessageId extends SysId
  {
  }
  public static class KeychainId extends SysId
  {
  }
  public static class KeychainSecretId extends SysId
  {
  }
  public static class MediaId extends SysId
  {
  }
  public static class MediaIdAudio extends MediaId
  {
  }
  public static class MediaIdAvatar extends MediaId
  {
  }
  public static class MediaIdDocument extends MediaId
  {
  }
  public static class MediaIdIcon extends MediaId
  {
  }
  public static class MediaIdImage extends MediaId
  {
  }
  public static class MediaIdJar extends MediaId
  {
  }
  public static class MediaIdSticker extends MediaId
  {
  }
  public static class MediaIdThumbnail extends MediaId
  {
  }
  public static class MediaIdVideo extends MediaId
  {
  }
  public static class MediaIdVoice extends MediaId
  {
  }
  public static class MessageId extends SysId
  {
  }
  public static class MetaId extends SysId
  {
  }
  public static class MetaIdAction extends MetaId
  {
  }
  public static class MetaIdAutomation extends MetaId
  {
  }
  public static class MetaIdChartXAxis extends MetaId
  {
  }
  public static class MetaIdChartYAxis extends MetaId
  {
  }
  public static class MetaIdCode extends MetaId
  {
  }
  public static class MetaIdComp extends MetaId
  {
  }
  public static class MetaIdComposite extends MetaIdComp
  {
  }
  public static class MetaIdCondition extends MetaId
  {
  }
  public static class MetaIdDeeplink extends MetaId
  {
  }
  public static class MetaIdDriveSheet extends MetaId
  {
  }
  public static class MetaIdEvent extends MetaId
  {
  }
  public static class MetaIdField extends MetaIdComp
  {
  }
  public static class MetaIdFieldDynamicCondition extends MetaId
  {
  }
  public static class MetaIdFieldDynamicRule extends MetaId
  {
  }
  public static class MetaIdFooter extends MetaId
  {
  }
  public static class MetaIdForm extends MetaId
  {
  }
  public static class MetaIdFormula extends MetaId
  {
  }
  public static class MetaIdFuncArg extends MetaId
  {
  }
  public static class MetaIdGrid extends MetaIdComposite
  {
  }
  public static class MetaIdGroup extends MetaId
  {
  }
  public static class MetaIdHeader extends MetaId
  {
  }
  public static class MetaIdHyperlink extends MetaId
  {
  }
  public static class MetaIdLayoutDriveSheet extends MetaId
  {
  }
  public static class MetaIdLayoutForm extends MetaId
  {
  }
  public static class MetaIdLayoutFormEditorComposite extends MetaId
  {
  }
  public static class MetaIdLayoutGrid extends MetaId
  {
  }
  public static class MetaIdLayoutUser extends MetaId
  {
  }
  public static class MetaIdMapping extends MetaId
  {
  }
  public static class MetaIdModule extends MetaId
  {
  }
  public static class MetaIdOption extends MetaId
  {
  }
  public static class MetaIdPartition extends MetaId
  {
  }
  public static class MetaIdPaymentProvider extends MetaId
  {
  }
  public static class MetaIdPipelineParam extends MetaId
  {
  }
  public static class MetaIdPipelineSystem extends MetaIdPipelineParam
  {
  }
  public static class MetaIdPipelineVar extends MetaIdPipelineParam
  {
  }
  public static class MetaIdPlugin extends MetaId
  {
  }
  public static class MetaIdPrompt extends MetaId
  {
  }
  public static class MetaIdReport extends MetaId
  {
  }
  public static class MetaIdRole extends MetaId
  {
  }
  public static class MetaIdSection extends MetaIdComposite
  {
  }
  public static class MetaIdSpreadsheet extends MetaId
  {
  }
  public static class MetaIdSpreadsheetRef extends MetaIdComposite
  {
  }
  public static class MetaIdStep extends MetaIdPipelineParam
  {
  }
  public static class MetaIdSwimlane extends MetaId
  {
  }
  public static class MetaIdTab extends MetaIdComposite
  {
  }
  public static class MetaIdTableStyle extends MetaId
  {
  }
  public static class MetaIdTranslation extends MetaId
  {
  }
  public static class MetaIdUserCondition extends MetaId
  {
  }
  public static class MetaIdVar extends MetaId
  {
  }
  public static class MetaIdVdAutoDia extends MetaId
  {
  }
  public static class MetaIdVdAutoEdge extends MetaId
  {
  }
  public static class MetaIdVdAutoFunc extends MetaId
  {
  }
  public static class MetaIdVdAutoNode extends MetaIdPipelineParam
  {
  }
  public static class MetaIdVdComment extends MetaId
  {
  }
  public static class MetaIdVdErdDia extends MetaId
  {
  }
  public static class MetaIdVdImageFunc extends MetaId
  {
  }
  public static class MetaIdVdNote extends MetaId
  {
  }
  public static class MetaIdVdRegion extends MetaId
  {
  }
  public static class MetaIdVdReportDia extends MetaId
  {
  }
  public static class MetaIdVdReview extends MetaId
  {
  }
  public static class MetaIdVideoTimestamp extends MetaId
  {
  }
  public static class MetaIdVisibilityAction extends MetaId
  {
  }
  public static class MetaIdVisibilityCondition extends MetaId
  {
  }
  public static class MetaIdVisibilityRule extends MetaId
  {
  }
  public static class MetaIdWizard extends MetaIdComposite
  {
  }
  public static class PluginApiId extends SysId
  {
  }
  public static class PluginBundleId extends ArtifactId
  {
  }
  public static class PluginId extends SysId
  {
  }
  public static class PluginResourceId extends SysId
  {
  }
  public static class ReportExecutionId extends SysId
  {
  }
  public static class RequestId extends SysId
  {
  }
  public static class RowId extends ChatId
  {
  }
  public static class SchedulerTaskId extends SysId
  {
  }
  public static class SheetId extends SysId
  {
  }
  public static class SnapshotId extends SysId
  {
  }
  public static class SpreadsheetPartitionId extends SysId
  {
  }
  public static class StoreItemId extends ArtifactId
  {
  }
  public static class TabId extends SysId
  {
  }
  public static class TransactionId extends SysId
  {
  }
  public static class UserId extends SysId
  {
  }
  public static class WorkflowExecutionId extends SysId
  {
  }
  public static class WorkflowGroupExecutionId extends SysId
  {
  }
  public static class AnyTime extends AnyValue
  {
  }
  public static class ColumnPath extends AnyValue
  {
  }
  public static class CurrencyKey extends AnyKey
  {
  }
  public static class GeoPoint extends AnyValue
  {
  }
  public static class HandleKey extends AnyKey
  {
  }
  public static class Key extends AnyKey
  {
  }
  public static class LanguageKey extends AnyKey
  {
  }
  public static class SearchPath extends AnyValue
  {
  }
  public static class SymbolColumn extends AnyValue
  {
  }
  public static class SymbolGrid extends AnyValue
  {
  }
  public static class TimeZoneKey extends AnyKey
  {
  }
}
