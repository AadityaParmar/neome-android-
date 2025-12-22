// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdEvent;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntAutomationCallableEventMap extends StudioBase
{
  public MetaIdEvent[] keys;

  public Map<MetaIdEvent, StudioEntAutomationCallableEvent> map;
}
