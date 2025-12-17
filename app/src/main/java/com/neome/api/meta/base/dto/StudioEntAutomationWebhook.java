// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnAutomationWebhookKind;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationWebhook extends StudioEntAutomation
{
  public EnumDefnAutomationWebhookKind callbackKind;

  public StudioEntAutomationWebhookEventMap eventMap;

  @Nullable
  public StudioDtoLocationCapture locationConfig;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
