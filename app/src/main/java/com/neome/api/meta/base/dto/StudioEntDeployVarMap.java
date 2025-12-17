// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVar;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntDeployVarMap extends StudioBase
{
  public MetaIdVar[] keys;

  public Map<MetaIdVar, StudioEntDeployVar> map;
}
