// neome.ai API - do not change
//

package com.neome.java.api.core.base.dto;

import com.neome.java.api.meta.base.Types.ChatId;
import com.neome.java.api.meta.base.dto.GsonCto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DtoEntChatNotificationSetting extends GsonCto
{
  @Nullable
  public DtoNotificationSetting entNotificationSetting;

  @Nullable
  public Map<ChatId, DtoNotificationSetting> map;
}
