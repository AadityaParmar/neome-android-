// neome.ai API - do not change
//

package com.neome.java.api.ent.agent.sig;

import com.neome.java.api.ent.base.dto.DtoAgentAdmin;
import com.neome.java.api.ent.base.dto.DtoAgentEntUser;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVar;
import com.neome.java.api.meta.base.dto.DefnForm;
import com.neome.java.api.meta.base.dto.DefnUserSettingVar;
import com.neome.java.api.meta.base.dto.SchemaSheet;
import com.neome.java.api.meta.base.dto.StudioEntDeployPluginMap;
import com.neome.java.api.meta.base.dto.StudioEntDetails;
import com.neome.java.api.meta.base.dto.StudioEntDriveSheetMap;
import com.neome.java.api.meta.base.dto.StudioEntPluginMap;
import com.neome.java.api.meta.base.dto.StudioEntRoleMap;
import com.neome.java.api.meta.base.dto.StudioEntSpreadsheetMap;
import com.neome.java.api.meta.base.dto.StudioModuleMap;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class SigAgentEnt extends SigVersion
{
  @Nullable
  public DtoAgentAdmin agentEntAdmin;

  @Nullable
  public DtoAgentEntUser agentEntUser;

  @Nullable
  public Map<MetaIdSpreadsheet, DefnForm> defnFormMap;

  @Nullable
  public StudioEntDetails details;

  @Nullable
  public StudioEntDriveSheetMap driveSheetMap;

  public StudioEntDeployPluginMap entDeployPluginMap;

  public StudioEntPluginMap entPluginMap;

  @Nullable
  public StudioModuleMap moduleMap;

  public StudioEntRoleMap roleMap;

  @Nullable
  public Map<MetaIdSpreadsheet, SchemaSheet> schemaSheetMap;

  public StudioEntSpreadsheetMap spreadsheetMap;

  @Nullable
  public Map<MetaIdVar, DefnUserSettingVar> userSettingVarMap;
}
