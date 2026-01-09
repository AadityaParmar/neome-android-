package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnButtonTargetType
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumDefnKindButton
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnDtoPluginApi
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldButton
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdAutomationSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoDiaSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnFieldButtonSeal : DefnFieldButton


@Serializable
data class DefnFieldButtonData(
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val disabledVar: Boolean? = null,
    override val hidden: Boolean? = null,
    override val hideDirtyIndicator: Boolean? = null,
    override val invisible: Boolean? = null,
    override val label: String? = null,
    override val maxWidth: Long? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pb: Long? = null,
    override val permissionMatrix: DefnDtoPermissionMatrix? = null,
    override val pl: Long? = null,
    override val pr: Long? = null,
    override val pt: Long? = null,
    override val readOnly: Boolean? = null,
    override val type: EnumDefnCompType,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val autoFill: Boolean? = null,
    override val autoFocus: Boolean? = null,
    override val helperText: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val helperTextFieldId: Types.MetaIdField? = null,
    override val helperTextVar: DefnDtoText? = null,
    override val hideLabel: Boolean? = null,
    override val icon: String? = null,
    override val iconVar: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val placeHolder: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val placeHolderFieldId: Types.MetaIdField? = null,
    override val placeHolderVar: DefnDtoText? = null,
    override val prefix: String? = null,
    override val prefixVar: DefnDtoText? = null,
    override val required: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val requiredFieldId: Types.MetaIdField? = null,
    override val requiredRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val requiredVar: Boolean? = null,
    override val suffix: String? = null,
    override val suffixVar: DefnDtoText? = null,
    override val actionClickButtonFieldIdArray: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionCloseAside: Boolean? = null,
    override val actionCustomHandlerId: String? = null,
    override val actionDisableFieldIdArray: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionEnableFieldIdArray: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionGroupIdSet: Array<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup>? = null,
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction? = null,
    @Serializable(with = MetaIdVarSer::class) override val actionInputMappingVarId: Types.MetaIdVar? = null,
    override val actionInvisibleFieldIdArray: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionInvokePluginApi: DefnDtoPluginApi? = null,
    @Serializable(with = MetaIdFieldSer::class) override val actionOpenLinkInNewTabFieldId: Types.MetaIdField? = null,
    override val actionOpenLinkInNewTabVar: DefnDtoHyperLink? = null,
    @Serializable(with = MetaIdFieldSer::class) override val actionOpenLinkInSameTabFieldId: Types.MetaIdField? = null,
    override val actionOpenLinkInSameTabVar: DefnDtoHyperLink? = null,
    @Serializable(with = MetaIdVarSer::class) override val actionOutputMappingVarId: Types.MetaIdVar? = null,
    override val actionSetDefaultFieldIdArray: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionToggleBooleanFieldIdArray: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val actionVisibleFieldIdArray: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdAutomationSer::class) override val automationId: Types.MetaIdAutomation? = null,
    @Serializable(with = MetaIdVarSer::class) override val automationInputMappingVarId: Types.MetaIdVar? = null,
    override val bgColor: DefnDtoColor? = null,
    override val bgColorVar: DefnDtoColor? = null,
    override val btnPosDoNotInline: Boolean? = null,
    override val btnPosFloating: Boolean? = null,
    override val btnPosFooter: Boolean? = null,
    override val btnPosMenu: Boolean? = null,
    override val btnPosToolbar: Boolean? = null,
    override val buttonKind: EnumDefnKindButton? = null,
    override val buttonPosition: EnumDefnPlacement? = null,
    override val buttonPositionVar: EnumDefnPlacement? = null,
    override val buttonVariant: EnumDefnThemeButtonVariant? = null,
    override val buttonVariantVar: EnumDefnThemeButtonVariant? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disableElevationFieldId: Types.MetaIdField? = null,
    override val disableElevationVar: Boolean? = null,
    override val disabledElevation: Boolean? = null,
    override val executeActionsAfterTargetSuccess: Boolean? = null,
    override val iconPosition: EnumDefnPlacement? = null,
    override val iconPositionVar: EnumDefnPlacement? = null,
    override val justifyContent: EnumDefnPlacement? = null,
    @Serializable(with = MetaIdFieldSer::class) override val pluginErrorFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport? = null,
    @Serializable(with = MetaIdVarSer::class) override val reportInputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val reportOutputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null,
    @Serializable(with = MetaIdVarSer::class) override val spreadsheetMappingVarId: Types.MetaIdVar? = null,
    override val targetType: EnumDefnButtonTargetType? = null,
    override val textSize: EnumDefnTextSize? = null,
    @Serializable(with = MetaIdFieldSer::class) override val textSizeFieldId: Types.MetaIdField? = null,
    override val textSizeVar: EnumDefnTextSize? = null,
    override val toastMessageOnClickVar: DefnDtoText? = null,
    override val toolTip: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val whatsAppHandleFieldId: Types.MetaIdField? = null,
    override val whatsAppMessage: DefnDtoParagraph? = null,
    @Serializable(with = MetaIdVdAutoDiaSer::class) override val workflowDiagramId: Types.MetaIdVdAutoDia? = null,
    @Serializable(with = MetaIdVarSer::class) override val workflowInputMappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val workflowStartNodeId: Types.MetaIdVdAutoNode? = null
) : DefnCompSeal, DefnFieldButton
