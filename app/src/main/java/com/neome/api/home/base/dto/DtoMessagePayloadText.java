// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoMessagePayloadText extends DtoMessagePayload
{
  @Nullable
  public Boolean isUpdated;

  public String text;
}
