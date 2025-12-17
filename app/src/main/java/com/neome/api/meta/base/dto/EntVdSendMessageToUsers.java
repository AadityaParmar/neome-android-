// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSendMessageToUsers extends EntVdAutoStep
{
  @Nullable
  public StudioValueParagraph message;

  @Nullable
  public StudioBuildArgBinder sender;

  @Nullable
  public StudioDtoUserFilter toUsers;
}
