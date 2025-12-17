// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioFormMap extends StudioBase
{
  public MetaIdForm[] keys;

  public Map<MetaIdForm, StudioForm> map;
}
