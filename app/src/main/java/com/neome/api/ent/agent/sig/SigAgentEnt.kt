// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnUserSettingVar
import com.neome.api.ent.base.dto.DtoAgentAdmin
import com.neome.api.ent.base.dto.DtoAgentEntUser
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.SchemaSheet
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.dto.StudioEntDeployPluginMap
import com.neome.api.meta.base.dto.StudioEntDetails
import com.neome.api.meta.base.dto.StudioEntDriveSheetMap
import com.neome.api.meta.base.dto.StudioEntPluginMap
import com.neome.api.meta.base.dto.StudioEntRoleMap
import com.neome.api.meta.base.dto.StudioEntSpreadsheetMap
import com.neome.api.meta.base.dto.StudioModuleMap

open class SigAgentEnt : SigVersion()
{
  var agentEntAdmin: DtoAgentAdmin? = null
  var agentEntUser: DtoAgentEntUser? = null
  var defnFormMap: Map<MetaIdSpreadsheet, DefnForm>? = null
  var details: StudioEntDetails? = null
  var driveSheetMap: StudioEntDriveSheetMap? = null
  lateinit var entDeployPluginMap: StudioEntDeployPluginMap
  lateinit var entPluginMap: StudioEntPluginMap
  var moduleMap: StudioModuleMap? = null
  lateinit var roleMap: StudioEntRoleMap
  var schemaSheetMap: Map<MetaIdSpreadsheet, SchemaSheet>? = null
  lateinit var spreadsheetMap: StudioEntSpreadsheetMap
  var userSettingVarMap: Map<MetaIdVar, DefnUserSettingVar>? = null
}