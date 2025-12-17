// neome.ai API - do not change
//

package com.neome.api.home.main.sig;

import com.neome.api.home.base.dto.DtoMessagePayload;
import com.neome.api.home.base.dto.DtoMessageReaction;
import com.neome.api.home.base.dto.DtoMessageReplyPayload;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MessageId;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.Map;

@SuppressWarnings("unused")
public class SigMessageBase extends Sig
{
  public Date creationTime;

  @Nullable
  public Boolean isCallerSender;

  public MessageId messageId;

  public long messageOffset;

  public DtoMessagePayload payload;

  @Nullable
  public Map<EntUserId, DtoMessageReaction> reactionMap;

  @Nullable
  public DtoMessageReplyPayload replyPayload;

  public EntUserId senderId;
}
