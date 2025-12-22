// neome.ai API - do not change
//

package com.neome.java.api.core.base.dto;

import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MessageId;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class NotificationCustomData
{
  @Nullable
  public ChatId chatId;

  @Nullable
  public EntId entId;

  @Nullable
  public MetaIdForm formId;

  @Nullable
  public Boolean isEntInvite;

  @Nullable
  public MessageId messageId;

  @Nullable
  public String messageType;

  @Nullable
  public ChatId parentChatId;

  @Nullable
  public MessageId parentMessageId;

  @Nullable
  public RowId rowId;

  @Nullable
  public EntUserId senderId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
