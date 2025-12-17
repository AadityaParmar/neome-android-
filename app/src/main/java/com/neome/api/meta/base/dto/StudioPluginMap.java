// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.PluginId;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioPluginMap extends StudioBase
{
  public PluginId[] keys;

  public Map<PluginId, StudioPlugin> map;
}
