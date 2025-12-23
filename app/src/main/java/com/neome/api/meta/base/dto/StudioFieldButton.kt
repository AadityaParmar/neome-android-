// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdWorkflowPointer
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
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText

open class StudioFieldButton : StudioFieldEditable()
{
  var actionClickButtonFieldIdArray: Array<MetaIdField>? = null
  var actionCloseAside: Boolean? = null
  var actionDisableFieldIdArray: Array<MetaIdField>? = null
  var actionEnableFieldIdArray: Array<MetaIdField>? = null
  var actionGroupIdSet: Array<MetaIdGroup>? = null
  var actionId: MetaIdAction? = null
  var actionInputMappingVarId: MetaIdVar? = null
  var actionInvisibleFieldIdArray: Array<MetaIdField>? = null
  var actionOpenLinkInNewTabFieldId: MetaIdField? = null
  var actionOpenLinkInNewTabVarId: MetaIdVar? = null
  var actionOpenLinkInSameTabFieldId: MetaIdField? = null
  var actionOpenLinkInSameTabVarId: MetaIdVar? = null
  var actionOutputMappingVarId: MetaIdVar? = null
  var actionSetDefaultFieldIdArray: Array<MetaIdField>? = null
  var actionToggleBooleanFieldIdArray: Array<MetaIdField>? = null
  var actionVisibleFieldIdArray: Array<MetaIdField>? = null
  var automationId: MetaIdAutomation? = null
  var automationInputMappingVarId: MetaIdVar? = null
  var bgColor: StudioDtoColor? = null
  var bgColorVarId: MetaIdVar? = null
  var btnPosDoNotInline: Boolean? = null
  var btnPosFloating: Boolean? = null
  var btnPosFooter: Boolean? = null
  var btnPosMenu: Boolean? = null
  var btnPosToolbar: Boolean? = null
  var buttonKind: EnumDefnKindButton? = null
  var buttonPosition: EnumDefnPlacement? = null
  var buttonPositionVarId: MetaIdVar? = null
  var buttonVariant: EnumDefnThemeButtonVariant? = null
  var buttonVariantVarId: MetaIdVar? = null
  var disableElevationFieldId: MetaIdField? = null
  var disableElevationVarId: MetaIdVar? = null
  var disabledElevation: Boolean? = null
  var executeActionsAfterTargetSuccess: Boolean? = null
  var iconPosition: EnumDefnPlacement? = null
  var iconPositionVarId: MetaIdVar? = null
  var pluginApi: StudioDtoPluginApi? = null
  var pluginErrorFieldId: MetaIdField? = null
  var pluginInputMappingVarId: MetaIdVar? = null
  var pluginOutputMappingVarId: MetaIdVar? = null
  var reportId: MetaIdReport? = null
  var reportInputMappingVarId: MetaIdVar? = null
  var reportOutputMappingVarId: MetaIdVar? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
  var spreadsheetMappingVarId: MetaIdVar? = null
  var targetType: EnumDefnButtonTargetType? = null
  var textSize: EnumDefnTextSize? = null
  var textSizeFieldId: MetaIdField? = null
  var textSizeVarId: MetaIdVar? = null
  var toastMessageOnClickVarId: StudioValueVarIdText? = null
  var toolTip: String? = null
  var whatsAppHandleFieldId: MetaIdField? = null
  var whatsAppMessageVarId: StudioValueVarIdParagraph? = null
  var workflowInputMappingVarId: MetaIdVar? = null
  var workflowPointer: EntVdWorkflowPointer? = null
}