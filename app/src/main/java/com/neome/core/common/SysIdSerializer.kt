package com.neome.core.common

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

open class SysIdSerializer<T : SysId>(descriptor: String) : KSerializer<T> {

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(descriptor, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): T {
        val string = decoder.decodeString()
        // Use SysId.create() to properly create and initialize the MessageId
        return SysId.create(string)
            ?: throw IllegalArgumentException("Failed to create SysId from: $string")
    }
}

// Base SysId serializers
object AdminIdSer : SysIdSerializer<Types.AdminId>("AdminId")
object ArtifactIdSer : SysIdSerializer<Types.ArtifactId>("ArtifactId")
object AutomationExecutionIdSer :
    SysIdSerializer<Types.AutomationExecutionId>("AutomationExecutionId")

object ChatIdSer : SysIdSerializer<Types.ChatId>("ChatId")
object ConnIdSer : SysIdSerializer<Types.ConnId>("ConnId")
object ContactIdSer : SysIdSerializer<Types.ContactId>("ContactId")
object DemoAppIdSer : SysIdSerializer<Types.DemoAppId>("DemoAppId")
object DeviceIdSer : SysIdSerializer<Types.DeviceId>("DeviceId")
object EntIdSer : SysIdSerializer<Types.EntId>("EntId")
object EntUserIdSer : SysIdSerializer<Types.EntUserId>("EntUserId")
object GhostIdSer : SysIdSerializer<Types.GhostId>("GhostId")
object GroupIdSer : SysIdSerializer<Types.GroupId>("GroupId")

// Inbox IDs
object InboxIdSer : SysIdSerializer<Types.InboxId>("InboxId")
object InboxIdFollowerSer : SysIdSerializer<Types.InboxIdFollower>("InboxIdFollower")
object InboxIdMasterSer : SysIdSerializer<Types.InboxIdMaster>("InboxIdMaster")
object InboxMessageIdSer : SysIdSerializer<Types.InboxMessageId>("InboxMessageId")

// Keychain IDs
object KeychainIdSer : SysIdSerializer<Types.KeychainId>("KeychainId")
object KeychainSecretIdSer : SysIdSerializer<Types.KeychainSecretId>("KeychainSecretId")

// Media IDs
object MediaIdSer : SysIdSerializer<Types.MediaId>("MediaId")
object MediaIdAudioSer : SysIdSerializer<Types.MediaIdAudio>("MediaIdAudio")
object MediaIdAvatarSer : SysIdSerializer<Types.MediaIdAvatar>("MediaIdAvatar")
object MediaIdDocumentSer : SysIdSerializer<Types.MediaIdDocument>("MediaIdDocument")
object MediaIdIconSer : SysIdSerializer<Types.MediaIdIcon>("MediaIdIcon")
object MediaIdImageSer : SysIdSerializer<Types.MediaIdImage>("MediaIdImage")
object MediaIdJarSer : SysIdSerializer<Types.MediaIdJar>("MediaIdJar")
object MediaIdStickerSer : SysIdSerializer<Types.MediaIdSticker>("MediaIdSticker")
object MediaIdThumbnailSer : SysIdSerializer<Types.MediaIdThumbnail>("MediaIdThumbnail")
object MediaIdVideoSer : SysIdSerializer<Types.MediaIdVideo>("MediaIdVideo")
object MediaIdVoiceSer : SysIdSerializer<Types.MediaIdVoice>("MediaIdVoice")

// Message ID
object MessageIdSer : SysIdSerializer<Types.MessageId>("MessageId")

// Meta IDs
object MetaIdSer : SysIdSerializer<Types.MetaId>("MetaId")
object MetaIdActionSer : SysIdSerializer<Types.MetaIdAction>("MetaIdAction")
object MetaIdAutomationSer : SysIdSerializer<Types.MetaIdAutomation>("MetaIdAutomation")
object MetaIdChartXAxisSer : SysIdSerializer<Types.MetaIdChartXAxis>("MetaIdChartXAxis")
object MetaIdChartYAxisSer : SysIdSerializer<Types.MetaIdChartYAxis>("MetaIdChartYAxis")
object MetaIdCodeSer : SysIdSerializer<Types.MetaIdCode>("MetaIdCode")
object MetaIdCompSer : SysIdSerializer<Types.MetaIdComp>("MetaIdComp")
object MetaIdCompositeSer : SysIdSerializer<Types.MetaIdComposite>("MetaIdComposite")
object MetaIdConditionSer : SysIdSerializer<Types.MetaIdCondition>("MetaIdCondition")
object MetaIdDeeplinkSer : SysIdSerializer<Types.MetaIdDeeplink>("MetaIdDeeplink")
object MetaIdDriveSheetSer : SysIdSerializer<Types.MetaIdDriveSheet>("MetaIdDriveSheet")
object MetaIdEventSer : SysIdSerializer<Types.MetaIdEvent>("MetaIdEvent")
object MetaIdFieldSer : SysIdSerializer<Types.MetaIdField>("MetaIdField")
object MetaIdFieldDynamicConditionSer :
    SysIdSerializer<Types.MetaIdFieldDynamicCondition>("MetaIdFieldDynamicCondition")

object MetaIdFieldDynamicRuleSer :
    SysIdSerializer<Types.MetaIdFieldDynamicRule>("MetaIdFieldDynamicRule")

object MetaIdFooterSer : SysIdSerializer<Types.MetaIdFooter>("MetaIdFooter")
object MetaIdFormSer : SysIdSerializer<Types.MetaIdForm>("MetaIdForm")
object MetaIdFormulaSer : SysIdSerializer<Types.MetaIdFormula>("MetaIdFormula")
object MetaIdFuncArgSer : SysIdSerializer<Types.MetaIdFuncArg>("MetaIdFuncArg")
object MetaIdGridSer : SysIdSerializer<Types.MetaIdGrid>("MetaIdGrid")
object MetaIdGroupSer : SysIdSerializer<Types.MetaIdGroup>("MetaIdGroup")
object MetaIdHeaderSer : SysIdSerializer<Types.MetaIdHeader>("MetaIdHeader")
object MetaIdHyperlinkSer : SysIdSerializer<Types.MetaIdHyperlink>("MetaIdHyperlink")
object MetaIdLayoutDriveSheetSer :
    SysIdSerializer<Types.MetaIdLayoutDriveSheet>("MetaIdLayoutDriveSheet")

object MetaIdLayoutFormSer : SysIdSerializer<Types.MetaIdLayoutForm>("MetaIdLayoutForm")
object MetaIdLayoutFormEditorCompositeSer :
    SysIdSerializer<Types.MetaIdLayoutFormEditorComposite>("MetaIdLayoutFormEditorComposite")

object MetaIdLayoutGridSer : SysIdSerializer<Types.MetaIdLayoutGrid>("MetaIdLayoutGrid")
object MetaIdLayoutUserSer : SysIdSerializer<Types.MetaIdLayoutUser>("MetaIdLayoutUser")
object MetaIdMappingSer : SysIdSerializer<Types.MetaIdMapping>("MetaIdMapping")
object MetaIdModuleSer : SysIdSerializer<Types.MetaIdModule>("MetaIdModule")
object MetaIdOptionSer : SysIdSerializer<Types.MetaIdOption>("MetaIdOption")
object MetaIdPartitionSer : SysIdSerializer<Types.MetaIdPartition>("MetaIdPartition")
object MetaIdPaymentProviderSer :
    SysIdSerializer<Types.MetaIdPaymentProvider>("MetaIdPaymentProvider")

object MetaIdPipelineParamSer : SysIdSerializer<Types.MetaIdPipelineParam>("MetaIdPipelineParam")
object MetaIdPipelineSystemSer : SysIdSerializer<Types.MetaIdPipelineSystem>("MetaIdPipelineSystem")
object MetaIdPipelineVarSer : SysIdSerializer<Types.MetaIdPipelineVar>("MetaIdPipelineVar")
object MetaIdPluginSer : SysIdSerializer<Types.MetaIdPlugin>("MetaIdPlugin")
object MetaIdPromptSer : SysIdSerializer<Types.MetaIdPrompt>("MetaIdPrompt")
object MetaIdReportSer : SysIdSerializer<Types.MetaIdReport>("MetaIdReport")
object MetaIdRoleSer : SysIdSerializer<Types.MetaIdRole>("MetaIdRole")
object MetaIdSectionSer : SysIdSerializer<Types.MetaIdSection>("MetaIdSection")
object MetaIdSpreadsheetSer : SysIdSerializer<Types.MetaIdSpreadsheet>("MetaIdSpreadsheet")
object MetaIdSpreadsheetRefSer : SysIdSerializer<Types.MetaIdSpreadsheetRef>("MetaIdSpreadsheetRef")
object MetaIdStepSer : SysIdSerializer<Types.MetaIdStep>("MetaIdStep")
object MetaIdSwimlaneSer : SysIdSerializer<Types.MetaIdSwimlane>("MetaIdSwimlane")
object MetaIdTabSer : SysIdSerializer<Types.MetaIdTab>("MetaIdTab")
object MetaIdTableStyleSer : SysIdSerializer<Types.MetaIdTableStyle>("MetaIdTableStyle")
object MetaIdTranslationSer : SysIdSerializer<Types.MetaIdTranslation>("MetaIdTranslation")
object MetaIdUserConditionSer : SysIdSerializer<Types.MetaIdUserCondition>("MetaIdUserCondition")
object MetaIdVarSer : SysIdSerializer<Types.MetaIdVar>("MetaIdVar")
object MetaIdVdAutoDiaSer : SysIdSerializer<Types.MetaIdVdAutoDia>("MetaIdVdAutoDia")
object MetaIdVdAutoEdgeSer : SysIdSerializer<Types.MetaIdVdAutoEdge>("MetaIdVdAutoEdge")
object MetaIdVdAutoFuncSer : SysIdSerializer<Types.MetaIdVdAutoFunc>("MetaIdVdAutoFunc")
object MetaIdVdAutoNodeSer : SysIdSerializer<Types.MetaIdVdAutoNode>("MetaIdVdAutoNode")
object MetaIdVdCommentSer : SysIdSerializer<Types.MetaIdVdComment>("MetaIdVdComment")
object MetaIdVdErdDiaSer : SysIdSerializer<Types.MetaIdVdErdDia>("MetaIdVdErdDia")
object MetaIdVdImageFuncSer : SysIdSerializer<Types.MetaIdVdImageFunc>("MetaIdVdImageFunc")
object MetaIdVdNoteSer : SysIdSerializer<Types.MetaIdVdNote>("MetaIdVdNote")
object MetaIdVdRegionSer : SysIdSerializer<Types.MetaIdVdRegion>("MetaIdVdRegion")
object MetaIdVdReportDiaSer : SysIdSerializer<Types.MetaIdVdReportDia>("MetaIdVdReportDia")
object MetaIdVdReviewSer : SysIdSerializer<Types.MetaIdVdReview>("MetaIdVdReview")
object MetaIdVideoTimestampSer : SysIdSerializer<Types.MetaIdVideoTimestamp>("MetaIdVideoTimestamp")
object MetaIdVisibilityActionSer :
    SysIdSerializer<Types.MetaIdVisibilityAction>("MetaIdVisibilityAction")

object MetaIdVisibilityConditionSer :
    SysIdSerializer<Types.MetaIdVisibilityCondition>("MetaIdVisibilityCondition")

object MetaIdVisibilityRuleSer : SysIdSerializer<Types.MetaIdVisibilityRule>("MetaIdVisibilityRule")
object MetaIdWizardSer : SysIdSerializer<Types.MetaIdWizard>("MetaIdWizard")

// Plugin IDs
object PluginApiIdSer : SysIdSerializer<Types.PluginApiId>("PluginApiId")
object PluginBundleIdSer : SysIdSerializer<Types.PluginBundleId>("PluginBundleId")
object PluginIdSer : SysIdSerializer<Types.PluginId>("PluginId")
object PluginResourceIdSer : SysIdSerializer<Types.PluginResourceId>("PluginResourceId")

// Other IDs
object ReportExecutionIdSer : SysIdSerializer<Types.ReportExecutionId>("ReportExecutionId")
object RequestIdSer : SysIdSerializer<Types.RequestId>("RequestId")
object RowIdSer : SysIdSerializer<Types.RowId>("RowId")
object SchedulerTaskIdSer : SysIdSerializer<Types.SchedulerTaskId>("SchedulerTaskId")
object SheetIdSer : SysIdSerializer<Types.SheetId>("SheetId")
object SnapshotIdSer : SysIdSerializer<Types.SnapshotId>("SnapshotId")
object SpreadsheetPartitionIdSer :
    SysIdSerializer<Types.SpreadsheetPartitionId>("SpreadsheetPartitionId")

object StoreItemIdSer : SysIdSerializer<Types.StoreItemId>("StoreItemId")
object TabIdSer : SysIdSerializer<Types.TabId>("TabId")
object TransactionIdSer : SysIdSerializer<Types.TransactionId>("TransactionId")
object UserIdSer : SysIdSerializer<Types.UserId>("UserId")
object WorkflowExecutionIdSer : SysIdSerializer<Types.WorkflowExecutionId>("WorkflowExecutionId")
object WorkflowGroupExecutionIdSer :
    SysIdSerializer<Types.WorkflowGroupExecutionId>("WorkflowGroupExecutionId")
