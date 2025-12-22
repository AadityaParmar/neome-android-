// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.DemoAppId
import com.neome.api.meta.base.Types.EntId

class StudioEnt : StudioDeployUnit() {
    val actionMap: StudioEntActionMap
    val autoDiaMap: EntVdAutoDiaMap
    val automationMap: StudioEntAutomationMap
    var createdBy: AdminId? = null
    var creationTime: string? = null
    val deeplinkMap: StudioEntDeeplinkMap
    val demoAppId: DemoAppId
    val deployVarMap: StudioEntDeployVarMap
    val details: StudioEntDetails
    val driveSheetMap: StudioEntDriveSheetMap
    val entId: EntId
    val erdDiaMap: EntVdErdDiaMap
    val formMap: StudioFormMap
    val groupMap: StudioEntGroupMap
    var lastUpdateBy: AdminId? = null
    var lastUpdateTime: string? = null
    var layoutUserMap: StudioMapOfLayoutUser? = null
    var layoutUserMenuActionMap: StudioMapOfActionPermission? = null
    val moduleMap: StudioModuleMap
    var nameCounterMap: StudioEntNameCounterMap? = null
    val pluginMap: StudioEntPluginMap
    val promptMap: StudioEntPromptMap
    val reportDiaMap: EntVdReportDiaMap
    val reportMap: StudioEntReportMap
    val roleMap: StudioEntRoleMap
    val spreadsheetMap: StudioEntSpreadsheetMap
    var storeItemDetailMap: StudioStoreItemDetailMap? = null
    val translationMap: StudioEntTranslationMap
    var trash: StudioEntTrash? = null
    val varMap: StudioVarMap
    var version: string? = null
    var versionCode: number? = null
}
