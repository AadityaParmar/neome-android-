// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSendPushNotification extends EntVdAutoStep
{
  @Nullable
  public StudioValueParagraph customMessage;

  @Nullable
  public StudioValueText customTitle;

  @Nullable
  public Boolean customize;

  @Nullable
  public StudioBuildArgBinder sender;

  @Nullable
  public StudioDtoUserFilter toUsers;
}
