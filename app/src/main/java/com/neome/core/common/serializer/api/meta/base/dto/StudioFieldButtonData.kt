package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnButtonTargetType
import com.neome.api.meta.base.Types.EnumDefnKindButton
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioFieldButton
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.api.meta.base.dto.EntVdWorkflowPointerData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPluginApiData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdAutomationSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFieldButtonData(
    override val aiInstructions: String? = null,
    override val details: StudioDetailsData,
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val disabledVarId: Types.MetaIdVar? = null,
    override val permissionMatrix: StudioDtoPermissionMatrixData? = null,
    override val type: EnumStudioCompType? = null,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val autoFill: Boolean? = null,
    override val autoFocus: Boolean? = null,
    override val helperText: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val helperTextFieldId: Types.MetaIdField? = null,
    override val helperTextVarId: StudioValueVarIdTextData? = null,
    override val hideLabel: Boolean? = null,
    override val icon: String? = null,
    @Serializable(with = MetaIdVarSer::class) override val iconVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val placeHolder: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val placeHolderFieldId: Types.MetaIdField? = null,
    override val placeHolderVarId: StudioValueVarIdTextData? = null,
    override val prefix: String? = null,
    override val prefixVarId: StudioValueVarIdTextData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val refFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdSer::class) override val refTargetId: Types.MetaId? = null,
    override val required: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val requiredFieldId: Types.MetaIdField? = null,
    override val requiredRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val requiredVarId: Types.MetaIdVar? = null,
    override val suffix: String? = null,
    override val suffixVarId: StudioValueVarIdTextData? = null,
    override val actionClickButtonFieldIdArray: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionCloseAside: Boolean? = null,
    override val actionDisableFieldIdArray: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionEnableFieldIdArray: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionGroupIdSet: List<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup>? = null,
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction? = null,
    @Serializable(with = MetaIdVarSer::class) override val actionInputMappingVarId: Types.MetaIdVar? = null,
    override val actionInvisibleFieldIdArray: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val actionOpenLinkInNewTabFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val actionOpenLinkInNewTabVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val actionOpenLinkInSameTabFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val actionOpenLinkInSameTabVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val actionOutputMappingVarId: Types.MetaIdVar? = null,
    override val actionSetDefaultFieldIdArray: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionToggleBooleanFieldIdArray: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionVisibleFieldIdArray: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdAutomationSer::class) override val automationId: Types.MetaIdAutomation? = null,
    @Serializable(with = MetaIdVarSer::class) override val automationInputMappingVarId: Types.MetaIdVar? = null,
    override val bgColor: StudioDtoColorData? = null,
    @Serializable(with = MetaIdVarSer::class) override val bgColorVarId: Types.MetaIdVar? = null,
    override val btnPosDoNotInline: Boolean? = null,
    override val btnPosFloating: Boolean? = null,
    override val btnPosFooter: Boolean? = null,
    override val btnPosMenu: Boolean? = null,
    override val btnPosToolbar: Boolean? = null,
    override val buttonKind: EnumDefnKindButton? = null,
    override val buttonPosition: EnumDefnPlacement? = null,
    @Serializable(with = MetaIdVarSer::class) override val buttonPositionVarId: Types.MetaIdVar? = null,
    override val buttonVariant: EnumDefnThemeButtonVariant? = null,
    @Serializable(with = MetaIdVarSer::class) override val buttonVariantVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disableElevationFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val disableElevationVarId: Types.MetaIdVar? = null,
    override val disabledElevation: Boolean? = null,
    override val executeActionsAfterTargetSuccess: Boolean? = null,
    override val iconPosition: EnumDefnPlacement? = null,
    @Serializable(with = MetaIdVarSer::class) override val iconPositionVarId: Types.MetaIdVar? = null,
    override val pluginApi: StudioDtoPluginApiData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val pluginErrorFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val pluginInputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val pluginOutputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport? = null,
    @Serializable(with = MetaIdVarSer::class) override val reportInputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val reportOutputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null,
    @Serializable(with = MetaIdVarSer::class) override val spreadsheetMappingVarId: Types.MetaIdVar? = null,
    override val targetType: EnumDefnButtonTargetType? = null,
    override val textSize: EnumDefnTextSize? = null,
    @Serializable(with = MetaIdFieldSer::class) override val textSizeFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val textSizeVarId: Types.MetaIdVar? = null,
    override val toastMessageOnClickVarId: StudioValueVarIdTextData? = null,
    override val toolTip: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val whatsAppHandleFieldId: Types.MetaIdField? = null,
    override val whatsAppMessageVarId: StudioValueVarIdParagraphData? = null,
    @Serializable(with = MetaIdVarSer::class) override val workflowInputMappingVarId: Types.MetaIdVar? = null,
    override val workflowPointer: EntVdWorkflowPointerData? = null
) : StudioFieldButton
