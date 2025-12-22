// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.meta.base.Types.MediaIdAudio;

@SuppressWarnings("unused")
public class DtoMessagePayloadAudio extends DtoMessagePayloadText
{
  public long durationMs;

  public long fileSize;

  public MediaIdAudio mediaIdAudio;
}
