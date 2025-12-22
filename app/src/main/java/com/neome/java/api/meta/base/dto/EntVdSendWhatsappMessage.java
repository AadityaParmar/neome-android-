// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSendWhatsappMessage extends EntVdAutoStep
{
  @Nullable
  public StudioDtoArgValueParameter mediaField;

  @Nullable
  public StudioValueParagraph message;

  @Nullable
  public StudioDtoUserFilter toUsers;
}
