// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdModule;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioModuleMap extends StudioBase
{
  public MetaIdModule[] keys;

  public Map<MetaIdModule, StudioModule> map;
}
