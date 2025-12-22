// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdVar;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioVarMap extends StudioBase
{
  public MetaIdVar[] keys;

  public Map<MetaIdVar, StudioVar> map;
}
