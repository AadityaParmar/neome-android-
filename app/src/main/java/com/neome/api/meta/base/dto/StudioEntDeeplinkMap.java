// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdDeeplink;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntDeeplinkMap extends StudioBase
{
  public MetaIdDeeplink[] keys;

  public Map<MetaIdDeeplink, StudioEntDeeplink> map;
}
