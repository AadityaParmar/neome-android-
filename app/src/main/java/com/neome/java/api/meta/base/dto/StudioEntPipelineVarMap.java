// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPipelineVar;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntPipelineVarMap extends StudioBase
{
  public MetaIdPipelineVar[] keys;

  public Map<MetaIdPipelineVar, StudioEntPipelineVar> map;
}
