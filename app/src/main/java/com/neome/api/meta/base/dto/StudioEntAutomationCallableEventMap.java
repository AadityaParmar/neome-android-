// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdEvent;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioEntAutomationCallableEvent;

@SuppressWarnings("unused")
public class StudioEntAutomationCallableEventMap extends StudioBase
{
  public MetaIdEvent[] keys;

  public Map<MetaIdEvent, StudioEntAutomationCallableEvent> map;
}
