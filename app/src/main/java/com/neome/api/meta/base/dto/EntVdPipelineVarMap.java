// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdPipelineVar;

import java.util.Map;

@SuppressWarnings("unused")
public class EntVdPipelineVarMap extends StudioBase
{
  public MetaIdPipelineVar[] keys;

  public Map<MetaIdPipelineVar, EntVdPipelineVar> map;
}
