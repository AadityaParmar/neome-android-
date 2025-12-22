// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.StoreItemId;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioStoreItemDetailMap extends StudioBase
{
  public StoreItemId[] keys;

  public Map<StoreItemId, StudioStoreItemDetail> map;
}
