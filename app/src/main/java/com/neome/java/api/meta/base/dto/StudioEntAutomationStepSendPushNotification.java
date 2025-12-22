// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendPushNotification
  extends StudioEntAutomationStepSendMessageBase
{
  @Nullable
  public StudioValueVarIdParagraph messageVarId;

  @Nullable
  public Boolean sendCustomMessage;

  @Nullable
  public StudioValueVarIdText titleVarId;
}
