// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSendEmail extends EntVdAutoStepWithError
{
  @Nullable
  public StudioDtoArgValueParameter attachmentField;

  @Nullable
  public StudioDtoUserFilter bccUsers;

  @Nullable
  public StudioDtoUserFilter ccUsers;

  @Nullable
  public StudioValueParagraph message;

  @Nullable
  public StudioDtoUserFilter replyToUsers;

  @Nullable
  public StudioValueText subject;

  @Nullable
  public StudioDtoUserFilter toUsers;
}
