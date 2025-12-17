// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVisibilityAction;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioVisibilityActionMap extends StudioBase
{
  public MetaIdVisibilityAction[] keys;

  public Map<MetaIdVisibilityAction, StudioVisibilityAction> map;
}
