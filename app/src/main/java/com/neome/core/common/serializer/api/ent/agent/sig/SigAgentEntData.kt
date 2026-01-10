package com.neome.core.common.serializer.api.ent.agent.sig

import com.neome.api.ent.agent.sig.SigAgentEnt
import com.neome.api.ent.base.dto.DtoAgentAdmin
import com.neome.api.ent.base.dto.DtoAgentEntUser
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnUserSettingVar
import com.neome.api.meta.base.dto.SchemaSheet
import com.neome.api.meta.base.dto.StudioEntDeployPluginMap
import com.neome.api.meta.base.dto.StudioEntDetails
import com.neome.api.meta.base.dto.StudioEntDriveSheetMap
import com.neome.api.meta.base.dto.StudioEntPluginMap
import com.neome.api.meta.base.dto.StudioEntRoleMap
import com.neome.api.meta.base.dto.StudioEntSpreadsheetMap
import com.neome.api.meta.base.dto.StudioModuleMap
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.ent.base.dto.DtoAgentAdminData
import com.neome.core.common.serializer.api.ent.base.dto.DtoAgentEntUserData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.DefnUserSettingVarData
import com.neome.core.common.serializer.api.meta.base.dto.SchemaSheetData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntDeployPluginMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntDriveSheetMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntRoleMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntSpreadsheetMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleMapData
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class SigAgentEntData(
    override val version: String,
    override val agentEntAdmin: DtoAgentAdminData? = null,
    override val agentEntUser: DtoAgentEntUserData? = null,
    override val defnFormMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, DefnFormData>? = null,
    override val details: StudioEntDetailsData? = null,
    override val driveSheetMap: StudioEntDriveSheetMapData? = null,
    override val entDeployPluginMap: StudioEntDeployPluginMapData,
    override val entPluginMap: StudioEntPluginMapData,
    override val moduleMap: StudioModuleMapData? = null,
    override val roleMap: StudioEntRoleMapData,
    override val schemaSheetMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, SchemaSheetData>? = null,
    override val spreadsheetMap: StudioEntSpreadsheetMapData,
    override val userSettingVarMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, DefnUserSettingVarData>? = null
) : SigAgentEnt
