// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdEvent;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntAutomationPluginWebhookEventMap extends StudioBase
{
  public MetaIdEvent[] keys;

  public Map<MetaIdEvent, StudioEntAutomationPluginWebhookEvent> map;
}
