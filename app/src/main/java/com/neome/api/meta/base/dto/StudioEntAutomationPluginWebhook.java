// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.dto.StudioDtoPluginApi;
import com.neome.api.meta.base.dto.StudioEntAutomation;
import com.neome.api.meta.base.dto.StudioEntAutomationPluginWebhookEventMap;

@SuppressWarnings("unused")
public class StudioEntAutomationPluginWebhook extends StudioEntAutomation
{
  public StudioEntAutomationPluginWebhookEventMap eventMap;

  public StudioDtoPluginApi pluginApi;
}