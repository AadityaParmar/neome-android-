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

class DefnFieldButton : DefnFieldEditable() {
    var actionClickButtonFieldIdArray: MetaIdField[]? = null
    var actionCloseAside: boolean? = null
    var actionCustomHandlerId: string? = null
    var actionDisableFieldIdArray: MetaIdField[]? = null
    var actionEnableFieldIdArray: MetaIdField[]? = null
    var actionGroupIdSet: MetaIdGroup[]? = null
    var actionId: MetaIdAction? = null
    var actionInputMappingVarId: MetaIdVar? = null
    var actionInvisibleFieldIdArray: MetaIdField[]? = null
    var actionInvokePluginApi: DefnDtoPluginApi? = null
    var actionOpenLinkInNewTabFieldId: MetaIdField? = null
    var actionOpenLinkInNewTabVar: DefnDtoHyperLink? = null
    var actionOpenLinkInSameTabFieldId: MetaIdField? = null
    var actionOpenLinkInSameTabVar: DefnDtoHyperLink? = null
    var actionOutputMappingVarId: MetaIdVar? = null
    var actionSetDefaultFieldIdArray: MetaIdField[]? = null
    var actionToggleBooleanFieldIdArray: MetaIdField[]? = null
    var actionVisibleFieldIdArray: MetaIdField[]? = null
    var automationId: MetaIdAutomation? = null
    var automationInputMappingVarId: MetaIdVar? = null
    var bgColor: DefnDtoColor? = null
    var bgColorVar: DefnDtoColor? = null
    var btnPosDoNotInline: boolean? = null
    var btnPosFloating: boolean? = null
    var btnPosFooter: boolean? = null
    var btnPosMenu: boolean? = null
    var btnPosToolbar: boolean? = null
    var buttonKind: EnumDefnKindButton? = null
    var buttonPosition: EnumDefnPlacement? = null
    var buttonPositionVar: EnumDefnPlacement? = null
    var buttonVariant: EnumDefnThemeButtonVariant? = null
    var buttonVariantVar: EnumDefnThemeButtonVariant? = null
    var disableElevationFieldId: MetaIdField? = null
    var disableElevationVar: boolean? = null
    var disabledElevation: boolean? = null
    var executeActionsAfterTargetSuccess: boolean? = null
    var iconPosition: EnumDefnPlacement? = null
    var iconPositionVar: EnumDefnPlacement? = null
    var justifyContent: EnumDefnPlacement? = null
    var pluginErrorFieldId: MetaIdField? = null
    var reportId: MetaIdReport? = null
    var reportInputMappingVarId: MetaIdVar? = null
    var reportOutputMappingVarId: MetaIdVar? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
    var spreadsheetMappingVarId: MetaIdVar? = null
    var targetType: EnumDefnButtonTargetType? = null
    var textSize: EnumDefnTextSize? = null
    var textSizeFieldId: MetaIdField? = null
    var textSizeVar: EnumDefnTextSize? = null
    var toastMessageOnClickVar: DefnDtoText? = null
    var toolTip: string? = null
    var whatsAppHandleFieldId: MetaIdField? = null
    var whatsAppMessage: DefnDtoParagraph? = null
    var workflowDiagramId: MetaIdVdAutoDia? = null
    var workflowInputMappingVarId: MetaIdVar? = null
    var workflowStartNodeId: MetaIdVdAutoNode? = null
}
