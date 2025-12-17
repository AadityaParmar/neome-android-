// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdComposite;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioCompositeMap extends StudioBase
{
  public MetaIdComposite[] keys;

  public Map<MetaIdComposite, StudioComposite> map;
}
