// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.AdminId;
import com.neome.java.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntDeployPluginMap extends StudioBase
{
  public MetaIdPlugin[] keys;

  public Map<MetaIdPlugin, StudioEntDeployPlugin> map;

  @Nullable
  public AdminId singletonPluginsAdminId;
}
