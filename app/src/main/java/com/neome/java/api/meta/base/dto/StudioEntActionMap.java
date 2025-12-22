// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAction;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntActionMap extends StudioBase
{
  public MetaIdAction[] keys;

  public Map<MetaIdAction, StudioEntAction> map;
}
