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
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class SigAgentEntData(
    override val version: String,
    override val agentEntAdmin: DtoAgentAdmin? = null,
    override val agentEntUser: DtoAgentEntUser? = null,
    override val defnFormMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, DefnForm>? = null,
    override val details: StudioEntDetails? = null,
    override val driveSheetMap: StudioEntDriveSheetMap? = null,
    override val entDeployPluginMap: StudioEntDeployPluginMap,
    override val entPluginMap: StudioEntPluginMap,
    override val moduleMap: StudioModuleMap? = null,
    override val roleMap: StudioEntRoleMap,
    override val schemaSheetMap: Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, SchemaSheet>? = null,
    override val spreadsheetMap: StudioEntSpreadsheetMap,
    override val userSettingVarMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, DefnUserSettingVar>? = null
) : SigAgentEnt
