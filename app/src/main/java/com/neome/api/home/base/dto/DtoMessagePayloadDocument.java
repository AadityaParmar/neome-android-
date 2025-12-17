// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.meta.base.Types.MediaIdDocument;

@SuppressWarnings("unused")
public class DtoMessagePayloadDocument extends DtoMessagePayload
{
  public String fileExt;

  public String fileName;

  public long fileSize;

  public MediaIdDocument mediaIdDocument;
}
