// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.meta.base.Types.MediaIdImage;
import com.neome.java.api.meta.base.Types.MediaIdVideo;

@SuppressWarnings("unused")
public class DtoMessageReplyPayloadVideo extends DtoMessageReplyPayload
{
  public long durationMs;

  public MediaIdImage mediaId;

  public MediaIdImage mediaIdBlurImage;

  public MediaIdVideo mediaIdVideo;

  public String primaryColor;
}
