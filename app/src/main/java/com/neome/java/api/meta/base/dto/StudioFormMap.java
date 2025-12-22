// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioFormMap extends StudioBase
{
  public MetaIdForm[] keys;

  public Map<MetaIdForm, StudioForm> map;
}
