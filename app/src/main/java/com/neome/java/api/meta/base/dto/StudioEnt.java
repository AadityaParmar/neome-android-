// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.AdminId;
import com.neome.java.api.meta.base.Types.DemoAppId;
import com.neome.java.api.meta.base.Types.EntId;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioEnt extends StudioDeployUnit
{
  public StudioEntActionMap actionMap;

  public EntVdAutoDiaMap autoDiaMap;

  public StudioEntAutomationMap automationMap;

  @Nullable
  public AdminId createdBy;

  @Nullable
  public Date creationTime;

  public StudioEntDeeplinkMap deeplinkMap;

  public DemoAppId demoAppId;

  public StudioEntDeployVarMap deployVarMap;

  public StudioEntDetails details;

  public StudioEntDriveSheetMap driveSheetMap;

  public EntId entId;

  public EntVdErdDiaMap erdDiaMap;

  public StudioFormMap formMap;

  public StudioEntGroupMap groupMap;

  @Nullable
  public AdminId lastUpdateBy;

  @Nullable
  public Date lastUpdateTime;

  @Nullable
  public StudioMapOfLayoutUser layoutUserMap;

  @Nullable
  public StudioMapOfActionPermission layoutUserMenuActionMap;

  public StudioModuleMap moduleMap;

  @Nullable
  public StudioEntNameCounterMap nameCounterMap;

  public StudioEntPluginMap pluginMap;

  public StudioEntPromptMap promptMap;

  public EntVdReportDiaMap reportDiaMap;

  public StudioEntReportMap reportMap;

  public StudioEntRoleMap roleMap;

  public StudioEntSpreadsheetMap spreadsheetMap;

  @Nullable
  public StudioStoreItemDetailMap storeItemDetailMap;

  public StudioEntTranslationMap translationMap;

  @Nullable
  public StudioEntTrash trash;

  public StudioVarMap varMap;

  @Nullable
  public String version;

  @Nullable
  public Long versionCode;
}
