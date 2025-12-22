// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MessageId;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoStarMessage
{
  public ChatId chatId;

  public Date creationDate;

  public EntId entId;

  public MessageId messageId;

  public long messageOffset;

  public EntUserId senderId;
}
