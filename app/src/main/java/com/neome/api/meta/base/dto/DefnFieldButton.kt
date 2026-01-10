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
import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

interface DefnFieldButton : DefnFieldEditable {
    val actionClickButtonFieldIdArray: List<MetaIdField>?
    val actionCloseAside: Boolean?
    val actionCustomHandlerId: String?
    val actionDisableFieldIdArray: List<MetaIdField>?
    val actionEnableFieldIdArray: List<MetaIdField>?
    val actionGroupIdSet: List<MetaIdGroup>?
    val actionId: MetaIdAction?
    val actionInputMappingVarId: MetaIdVar?
    val actionInvisibleFieldIdArray: List<MetaIdField>?
    val actionInvokePluginApi: DefnDtoPluginApi?
    val actionOpenLinkInNewTabFieldId: MetaIdField?
    val actionOpenLinkInNewTabVar: DefnDtoHyperLink?
    val actionOpenLinkInSameTabFieldId: MetaIdField?
    val actionOpenLinkInSameTabVar: DefnDtoHyperLink?
    val actionOutputMappingVarId: MetaIdVar?
    val actionSetDefaultFieldIdArray: List<MetaIdField>?
    val actionToggleBooleanFieldIdArray: List<MetaIdField>?
    val actionVisibleFieldIdArray: List<MetaIdField>?
    val automationId: MetaIdAutomation?
    val automationInputMappingVarId: MetaIdVar?
    val bgColor: DefnDtoColor?
    val bgColorVar: DefnDtoColor?
    val btnPosDoNotInline: Boolean?
    val btnPosFloating: Boolean?
    val btnPosFooter: Boolean?
    val btnPosMenu: Boolean?
    val btnPosToolbar: Boolean?
    val buttonKind: EnumDefnKindButton?
    val buttonPosition: EnumDefnPlacement?
    val buttonPositionVar: EnumDefnPlacement?
    val buttonVariant: EnumDefnThemeButtonVariant?
    val buttonVariantVar: EnumDefnThemeButtonVariant?
    val disableElevationFieldId: MetaIdField?
    val disableElevationVar: Boolean?
    val disabledElevation: Boolean?
    val executeActionsAfterTargetSuccess: Boolean?
    val iconPosition: EnumDefnPlacement?
    val iconPositionVar: EnumDefnPlacement?
    val justifyContent: EnumDefnPlacement?
    val pluginErrorFieldId: MetaIdField?
    val reportId: MetaIdReport?
    val reportInputMappingVarId: MetaIdVar?
    val reportOutputMappingVarId: MetaIdVar?
    val spreadsheetId: MetaIdSpreadsheet?
    val spreadsheetMappingVarId: MetaIdVar?
    val targetType: EnumDefnButtonTargetType?
    val textSize: EnumDefnTextSize?
    val textSizeFieldId: MetaIdField?
    val textSizeVar: EnumDefnTextSize?
    val toastMessageOnClickVar: DefnDtoText?
    val toolTip: String?
    val whatsAppHandleFieldId: MetaIdField?
    val whatsAppMessage: DefnDtoParagraph?
    val workflowDiagramId: MetaIdVdAutoDia?
    val workflowInputMappingVarId: MetaIdVar?
    val workflowStartNodeId: MetaIdVdAutoNode?
}
