// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.home.base.Types.EnumReceiptStatus;
import com.neome.java.api.home.base.dto.DtoMessagePayload;
import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MessageId;
import com.neome.java.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class SigLastMessage extends SigVersion
{
  public ChatId chatId;

  public EntId entId;

  public MessageId messageId;

  public long messageOffset;

  public DtoMessagePayload messagePayload;

  public String messageSummary;

  public Date messageTime;

  @Nullable
  public EnumReceiptStatus receiptStatus;

  public EntUserId senderId;
}
