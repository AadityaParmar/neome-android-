// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.meta.base.Types.MediaIdImage;

@SuppressWarnings("unused")
public class DtoMessagePayloadImage extends DtoMessagePayloadText
{
  public long fileSize;

  public long height;

  public MediaIdImage mediaIdBlurImage;

  public MediaIdImage mediaIdImage;

  public String primaryColor;

  public long width;
}
