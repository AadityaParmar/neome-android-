// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.agent.sig

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnUserSettingVar
import com.neome.api.ent.base.dto.DtoAgentAdmin
import com.neome.api.ent.base.dto.DtoAgentEntUser
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

interface SigAgentEnt : SigVersion
{
  val agentEntAdmin: DtoAgentAdmin?
  val agentEntUser: DtoAgentEntUser?
  val defnFormMap: Map<MetaIdSpreadsheet, DefnForm>?
  val details: StudioEntDetails?
  val driveSheetMap: StudioEntDriveSheetMap?
  val entDeployPluginMap: StudioEntDeployPluginMap
  val entPluginMap: StudioEntPluginMap
  val moduleMap: StudioModuleMap?
  val roleMap: StudioEntRoleMap
  val schemaSheetMap: Map<MetaIdSpreadsheet, SchemaSheet>?
  val spreadsheetMap: StudioEntSpreadsheetMap
  val userSettingVarMap: Map<MetaIdVar, DefnUserSettingVar>?
}