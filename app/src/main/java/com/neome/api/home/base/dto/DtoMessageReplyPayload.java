// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.home.base.Types.EnumMessageType;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MessageId;

@SuppressWarnings("unused")
public class DtoMessageReplyPayload
{
  public MessageId messageId;

  public EnumMessageType messageType;

  public EntUserId senderId;
}
