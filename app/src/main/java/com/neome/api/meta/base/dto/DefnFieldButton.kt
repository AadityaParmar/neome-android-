// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoPluginApi
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldEditable
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

open class DefnFieldButton : DefnFieldEditable()
{
  var actionClickButtonFieldIdArray: Array<MetaIdField>? = null
  var actionCloseAside: Boolean? = null
  var actionCustomHandlerId: String? = null
  var actionDisableFieldIdArray: Array<MetaIdField>? = null
  var actionEnableFieldIdArray: Array<MetaIdField>? = null
  var actionGroupIdSet: Array<MetaIdGroup>? = null
  var actionId: MetaIdAction? = null
  var actionInputMappingVarId: MetaIdVar? = null
  var actionInvisibleFieldIdArray: Array<MetaIdField>? = null
  var actionInvokePluginApi: DefnDtoPluginApi? = null
  var actionOpenLinkInNewTabFieldId: MetaIdField? = null
  var actionOpenLinkInNewTabVar: DefnDtoHyperLink? = null
  var actionOpenLinkInSameTabFieldId: MetaIdField? = null
  var actionOpenLinkInSameTabVar: DefnDtoHyperLink? = null
  var actionOutputMappingVarId: MetaIdVar? = null
  var actionSetDefaultFieldIdArray: Array<MetaIdField>? = null
  var actionToggleBooleanFieldIdArray: Array<MetaIdField>? = null
  var actionVisibleFieldIdArray: Array<MetaIdField>? = null
  var automationId: MetaIdAutomation? = null
  var automationInputMappingVarId: MetaIdVar? = null
  var bgColor: DefnDtoColor? = null
  var bgColorVar: DefnDtoColor? = null
  var btnPosDoNotInline: Boolean? = null
  var btnPosFloating: Boolean? = null
  var btnPosFooter: Boolean? = null
  var btnPosMenu: Boolean? = null
  var btnPosToolbar: Boolean? = null
  var buttonKind: EnumDefnKindButton? = null
  var buttonPosition: EnumDefnPlacement? = null
  var buttonPositionVar: EnumDefnPlacement? = null
  var buttonVariant: EnumDefnThemeButtonVariant? = null
  var buttonVariantVar: EnumDefnThemeButtonVariant? = null
  var disableElevationFieldId: MetaIdField? = null
  var disableElevationVar: Boolean? = null
  var disabledElevation: Boolean? = null
  var executeActionsAfterTargetSuccess: Boolean? = null
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
  var toolTip: String? = null
  var whatsAppHandleFieldId: MetaIdField? = null
  var whatsAppMessage: DefnDtoParagraph? = null
  var workflowDiagramId: MetaIdVdAutoDia? = null
  var workflowInputMappingVarId: MetaIdVar? = null
  var workflowStartNodeId: MetaIdVdAutoNode? = null
}