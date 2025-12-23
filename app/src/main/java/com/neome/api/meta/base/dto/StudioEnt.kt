// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import java.util.Date
import com.neome.api.meta.base.Types.DemoAppId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.dto.EntVdAutoDiaMap
import com.neome.api.meta.base.dto.EntVdErdDiaMap
import com.neome.api.meta.base.dto.EntVdReportDiaMap
import com.neome.api.meta.base.dto.StudioDeployUnit
import com.neome.api.meta.base.dto.StudioEntActionMap
import com.neome.api.meta.base.dto.StudioEntAutomationMap
import com.neome.api.meta.base.dto.StudioEntDeeplinkMap
import com.neome.api.meta.base.dto.StudioEntDeployVarMap
import com.neome.api.meta.base.dto.StudioEntDetails
import com.neome.api.meta.base.dto.StudioEntDriveSheetMap
import com.neome.api.meta.base.dto.StudioEntGroupMap
import com.neome.api.meta.base.dto.StudioEntNameCounterMap
import com.neome.api.meta.base.dto.StudioEntPluginMap
import com.neome.api.meta.base.dto.StudioEntPromptMap
import com.neome.api.meta.base.dto.StudioEntReportMap
import com.neome.api.meta.base.dto.StudioEntRoleMap
import com.neome.api.meta.base.dto.StudioEntSpreadsheetMap
import com.neome.api.meta.base.dto.StudioEntTranslationMap
import com.neome.api.meta.base.dto.StudioEntTrash
import com.neome.api.meta.base.dto.StudioFormMap
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.api.meta.base.dto.StudioMapOfLayoutUser
import com.neome.api.meta.base.dto.StudioModuleMap
import com.neome.api.meta.base.dto.StudioStoreItemDetailMap
import com.neome.api.meta.base.dto.StudioVarMap

open class StudioEnt : StudioDeployUnit()
{
  lateinit var actionMap: StudioEntActionMap
  lateinit var autoDiaMap: EntVdAutoDiaMap
  lateinit var automationMap: StudioEntAutomationMap
  var createdBy: AdminId? = null
  var creationTime: String? = null
  lateinit var deeplinkMap: StudioEntDeeplinkMap
  lateinit var demoAppId: DemoAppId
  lateinit var deployVarMap: StudioEntDeployVarMap
  lateinit var details: StudioEntDetails
  lateinit var driveSheetMap: StudioEntDriveSheetMap
  lateinit var entId: EntId
  lateinit var erdDiaMap: EntVdErdDiaMap
  lateinit var formMap: StudioFormMap
  lateinit var groupMap: StudioEntGroupMap
  var lastUpdateBy: AdminId? = null
  var lastUpdateTime: String? = null
  var layoutUserMap: StudioMapOfLayoutUser? = null
  var layoutUserMenuActionMap: StudioMapOfActionPermission? = null
  lateinit var moduleMap: StudioModuleMap
  var nameCounterMap: StudioEntNameCounterMap? = null
  lateinit var pluginMap: StudioEntPluginMap
  lateinit var promptMap: StudioEntPromptMap
  lateinit var reportDiaMap: EntVdReportDiaMap
  lateinit var reportMap: StudioEntReportMap
  lateinit var roleMap: StudioEntRoleMap
  lateinit var spreadsheetMap: StudioEntSpreadsheetMap
  var storeItemDetailMap: StudioStoreItemDetailMap? = null
  lateinit var translationMap: StudioEntTranslationMap
  var trash: StudioEntTrash? = null
  lateinit var varMap: StudioVarMap
  var version: String? = null
  var versionCode: Number? = null
}