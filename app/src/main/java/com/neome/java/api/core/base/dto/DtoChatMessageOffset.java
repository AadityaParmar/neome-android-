// neome.ai API - do not change
//

package com.neome.java.api.core.base.dto;

import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoChatMessageOffset
{
  @Nullable
  public ChatId chatId;

  @Nullable
  public Long offset;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
