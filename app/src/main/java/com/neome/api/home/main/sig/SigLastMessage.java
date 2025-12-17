// neome.ai API - do not change
//

package com.neome.api.home.main.sig;

import com.neome.api.home.base.Types.EnumReceiptStatus;
import com.neome.api.home.base.dto.DtoMessagePayload;
import com.neome.api.meta.base.Types.ChatId;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.meta.base.Types.MessageId;
import com.neome.api.nucleus.base.sig.SigVersion;

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
