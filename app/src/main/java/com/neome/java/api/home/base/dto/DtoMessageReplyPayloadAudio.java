// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.meta.base.Types.MediaIdAudio;

@SuppressWarnings("unused")
public class DtoMessageReplyPayloadAudio extends DtoMessageReplyPayload
{
  public long durationMs;

  public MediaIdAudio mediaIdAudio;
}
