// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnButtonTargetType
import com.neome.api.meta.base.Types.EnumDefnKindButton
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioFieldButton : StudioFieldEditable {
    val actionClickButtonFieldIdArray: List<MetaIdField>?
    val actionCloseAside: Boolean?
    val actionDisableFieldIdArray: List<MetaIdField>?
    val actionEnableFieldIdArray: List<MetaIdField>?
    val actionGroupIdSet: List<MetaIdGroup>?
    val actionId: MetaIdAction?
    val actionInputMappingVarId: MetaIdVar?
    val actionInvisibleFieldIdArray: List<MetaIdField>?
    val actionOpenLinkInNewTabFieldId: MetaIdField?
    val actionOpenLinkInNewTabVarId: MetaIdVar?
    val actionOpenLinkInSameTabFieldId: MetaIdField?
    val actionOpenLinkInSameTabVarId: MetaIdVar?
    val actionOutputMappingVarId: MetaIdVar?
    val actionSetDefaultFieldIdArray: List<MetaIdField>?
    val actionToggleBooleanFieldIdArray: List<MetaIdField>?
    val actionVisibleFieldIdArray: List<MetaIdField>?
    val automationId: MetaIdAutomation?
    val automationInputMappingVarId: MetaIdVar?
    val bgColor: StudioDtoColor?
    val bgColorVarId: MetaIdVar?
    val btnPosDoNotInline: Boolean?
    val btnPosFloating: Boolean?
    val btnPosFooter: Boolean?
    val btnPosMenu: Boolean?
    val btnPosToolbar: Boolean?
    val buttonKind: EnumDefnKindButton?
    val buttonPosition: EnumDefnPlacement?
    val buttonPositionVarId: MetaIdVar?
    val buttonVariant: EnumDefnThemeButtonVariant?
    val buttonVariantVarId: MetaIdVar?
    val disableElevationFieldId: MetaIdField?
    val disableElevationVarId: MetaIdVar?
    val disabledElevation: Boolean?
    val executeActionsAfterTargetSuccess: Boolean?
    val iconPosition: EnumDefnPlacement?
    val iconPositionVarId: MetaIdVar?
    val pluginApi: StudioDtoPluginApi?
    val pluginErrorFieldId: MetaIdField?
    val pluginInputMappingVarId: MetaIdVar?
    val pluginOutputMappingVarId: MetaIdVar?
    val reportId: MetaIdReport?
    val reportInputMappingVarId: MetaIdVar?
    val reportOutputMappingVarId: MetaIdVar?
    val spreadsheetId: MetaIdSpreadsheet?
    val spreadsheetMappingVarId: MetaIdVar?
    val targetType: EnumDefnButtonTargetType?
    val textSize: EnumDefnTextSize?
    val textSizeFieldId: MetaIdField?
    val textSizeVarId: MetaIdVar?
    val toastMessageOnClickVarId: StudioValueVarIdText?
    val toolTip: String?
    val whatsAppHandleFieldId: MetaIdField?
    val whatsAppMessageVarId: StudioValueVarIdParagraph?
    val workflowInputMappingVarId: MetaIdVar?
    val workflowPointer: EntVdWorkflowPointer?
}
