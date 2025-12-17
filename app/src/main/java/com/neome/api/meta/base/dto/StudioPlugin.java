// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.AdminId;
import com.neome.api.meta.base.Types.EnumDefnPluginMode;
import com.neome.api.meta.base.Types.PluginId;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioPlugin extends StudioDeployUnit
{
  public StudioPluginApiMap apiMap;

  @Nullable
  public AdminId createdBy;

  @Nullable
  public Date creationTime;

  public StudioPluginDeploy deploy;

  @Nullable
  public Boolean deprecate;

  public StudioPluginDetails details;

  public StudioFormMap formMap;

  @Nullable
  public AdminId lastUpdateBy;

  @Nullable
  public Date lastUpdateTime;

  public PluginId metaId;

  public EnumDefnPluginMode mode;

  public StudioModuleMap moduleMap;

  @Nullable
  public StudioPluginResourceMap resourceMap;

  @Nullable
  public StudioStoreItemDetailMap storeItemDetailMap;

  @Nullable
  public StudioPluginTrash trash;

  public StudioVarMap varMap;

  @Nullable
  public String version;
}
