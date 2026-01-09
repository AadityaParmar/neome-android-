package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdAutoDiaMap
import com.neome.api.meta.base.dto.EntVdErdDiaMap
import com.neome.api.meta.base.dto.EntVdReportDiaMap
import com.neome.api.meta.base.dto.StudioDeployUnit
import com.neome.api.meta.base.dto.StudioEnt
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
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.DemoAppIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntData(
    override val actionMap: StudioEntActionMap,
    override val autoDiaMap: EntVdAutoDiaMap,
    override val automationMap: StudioEntAutomationMap,
    @Serializable(with = AdminIdSer::class) override val createdBy: Types.AdminId? = null,
    override val creationTime: String? = null,
    override val deeplinkMap: StudioEntDeeplinkMap,
    @Serializable(with = DemoAppIdSer::class) override val demoAppId: Types.DemoAppId,
    override val deployVarMap: StudioEntDeployVarMap,
    override val details: StudioEntDetails,
    override val driveSheetMap: StudioEntDriveSheetMap,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val erdDiaMap: EntVdErdDiaMap,
    override val formMap: StudioFormMap,
    override val groupMap: StudioEntGroupMap,
    @Serializable(with = AdminIdSer::class) override val lastUpdateBy: Types.AdminId? = null,
    override val lastUpdateTime: String? = null,
    override val layoutUserMap: StudioMapOfLayoutUser? = null,
    override val layoutUserMenuActionMap: StudioMapOfActionPermission? = null,
    override val moduleMap: StudioModuleMap,
    override val nameCounterMap: StudioEntNameCounterMap? = null,
    override val pluginMap: StudioEntPluginMap,
    override val promptMap: StudioEntPromptMap,
    override val reportDiaMap: EntVdReportDiaMap,
    override val reportMap: StudioEntReportMap,
    override val roleMap: StudioEntRoleMap,
    override val spreadsheetMap: StudioEntSpreadsheetMap,
    override val storeItemDetailMap: StudioStoreItemDetailMap? = null,
    override val translationMap: StudioEntTranslationMap,
    override val trash: StudioEntTrash? = null,
    override val varMap: StudioVarMap,
    override val version: String? = null,
    override val versionCode: Long? = null
) : StudioEnt
