// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.meta.base.Types.MediaIdAudio;

@SuppressWarnings("unused")
public class DtoMessageReplyPayloadAudio extends DtoMessageReplyPayload
{
  public long durationMs;

  public MediaIdAudio mediaIdAudio;
}
