// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.meta.base.Types.ChatId;
import com.neome.api.meta.base.Types.EntId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoRecentItem
{
  public ChatId chatId;

  public EntId entId;

  @Nullable
  public Boolean isPinned;
}
