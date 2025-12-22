// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdGroup;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntGroupMap extends StudioBase
{
  public MetaIdGroup[] keys;

  public Map<MetaIdGroup, StudioEntGroup> map;
}
