// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPlugin;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntPluginMap extends StudioBase
{
  public MetaIdPlugin[] keys;

  public Map<MetaIdPlugin, StudioEntPlugin> map;
}
