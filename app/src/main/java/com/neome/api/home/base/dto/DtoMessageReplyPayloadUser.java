// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.meta.base.Types.MediaIdAvatar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoMessageReplyPayloadUser extends DtoMessageReplyPayload
{
  @Nullable
  public MediaIdAvatar mediaIdAvatar;

  public String userName;
}
