// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.home.base.dto.DtoMessagePayload;
import com.neome.java.api.home.base.dto.DtoMessageReaction;
import com.neome.java.api.home.base.dto.DtoMessageReplyPayload;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MessageId;
import com.neome.java.api.nucleus.base.sig.Sig;

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
