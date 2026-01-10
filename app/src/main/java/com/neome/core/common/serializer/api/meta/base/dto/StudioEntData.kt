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
import com.neome.core.common.serializer.api.meta.base.dto.EntVdAutoDiaMapData
import com.neome.core.common.serializer.api.meta.base.dto.EntVdErdDiaMapData
import com.neome.core.common.serializer.api.meta.base.dto.EntVdReportDiaMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntActionMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntAutomationMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntDeeplinkMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntDeployVarMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntDriveSheetMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntGroupMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntNameCounterMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPromptMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntReportMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntRoleMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntSpreadsheetMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntTranslationMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntTrashData
import com.neome.core.common.serializer.api.meta.base.dto.StudioFormMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfActionPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfLayoutUserData
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioStoreItemDetailMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioVarMapData
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.DemoAppIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntData(
    override val actionMap: StudioEntActionMapData,
    override val autoDiaMap: EntVdAutoDiaMapData,
    override val automationMap: StudioEntAutomationMapData,
    @Serializable(with = AdminIdSer::class) override val createdBy: Types.AdminId? = null,
    override val creationTime: String? = null,
    override val deeplinkMap: StudioEntDeeplinkMapData,
    @Serializable(with = DemoAppIdSer::class) override val demoAppId: Types.DemoAppId,
    override val deployVarMap: StudioEntDeployVarMapData,
    override val details: StudioEntDetailsData,
    override val driveSheetMap: StudioEntDriveSheetMapData,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val erdDiaMap: EntVdErdDiaMapData,
    override val formMap: StudioFormMapData,
    override val groupMap: StudioEntGroupMapData,
    @Serializable(with = AdminIdSer::class) override val lastUpdateBy: Types.AdminId? = null,
    override val lastUpdateTime: String? = null,
    override val layoutUserMap: StudioMapOfLayoutUserData? = null,
    override val layoutUserMenuActionMap: StudioMapOfActionPermissionData? = null,
    override val moduleMap: StudioModuleMapData,
    override val nameCounterMap: StudioEntNameCounterMapData? = null,
    override val pluginMap: StudioEntPluginMapData,
    override val promptMap: StudioEntPromptMapData,
    override val reportDiaMap: EntVdReportDiaMapData,
    override val reportMap: StudioEntReportMapData,
    override val roleMap: StudioEntRoleMapData,
    override val spreadsheetMap: StudioEntSpreadsheetMapData,
    override val storeItemDetailMap: StudioStoreItemDetailMapData? = null,
    override val translationMap: StudioEntTranslationMapData,
    override val trash: StudioEntTrashData? = null,
    override val varMap: StudioVarMapData,
    override val version: String? = null,
    override val versionCode: Long? = null
) : StudioEnt
