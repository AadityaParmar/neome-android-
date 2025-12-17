// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.meta.base.Types.MediaIdAudio;

@SuppressWarnings("unused")
public class DtoMessagePayloadAudio extends DtoMessagePayloadText
{
  public long durationMs;

  public long fileSize;

  public MediaIdAudio mediaIdAudio;
}
