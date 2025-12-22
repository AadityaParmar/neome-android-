// neome.ai API - do not change
//

package com.neome.java.api.home.base.dto;

import com.neome.java.api.home.main.sig.SigMessage;
import com.neome.java.api.meta.base.Types.ChatId;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoChatMessageListMap
{
  @Nullable
  public Map<ChatId, SigMessage[]> chatMessageListMap;
}
