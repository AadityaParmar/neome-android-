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

interface StudioEnt : StudioDeployUnit
{
  val actionMap: StudioEntActionMap
  val autoDiaMap: EntVdAutoDiaMap
  val automationMap: StudioEntAutomationMap
  val createdBy: AdminId?
  val creationTime: String?
  val deeplinkMap: StudioEntDeeplinkMap
  val demoAppId: DemoAppId
  val deployVarMap: StudioEntDeployVarMap
  val details: StudioEntDetails
  val driveSheetMap: StudioEntDriveSheetMap
  val entId: EntId
  val erdDiaMap: EntVdErdDiaMap
  val formMap: StudioFormMap
  val groupMap: StudioEntGroupMap
  val lastUpdateBy: AdminId?
  val lastUpdateTime: String?
  val layoutUserMap: StudioMapOfLayoutUser?
  val layoutUserMenuActionMap: StudioMapOfActionPermission?
  val moduleMap: StudioModuleMap
  val nameCounterMap: StudioEntNameCounterMap?
  val pluginMap: StudioEntPluginMap
  val promptMap: StudioEntPromptMap
  val reportDiaMap: EntVdReportDiaMap
  val reportMap: StudioEntReportMap
  val roleMap: StudioEntRoleMap
  val spreadsheetMap: StudioEntSpreadsheetMap
  val storeItemDetailMap: StudioStoreItemDetailMap?
  val translationMap: StudioEntTranslationMap
  val trash: StudioEntTrash?
  val varMap: StudioVarMap
  val version: String?
  val versionCode: Long?
}