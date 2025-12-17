// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.meta.base.Types.MediaIdImage;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoMessagePayloadLocation extends DtoMessagePayloadText
{
  @Nullable
  public String city;

  @Nullable
  public String country;

  public double latitude;

  public double longitude;

  public MediaIdImage mediaIdImage;
}
