// neome.ai API - do not change
//

package com.neome.api.home.aside.msg;

import com.neome.api.core.base.dto.DtoNotificationSetting;
import com.neome.api.meta.base.Types.ChatId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgCallerChatNotificationSettingPut extends Msg
{
  public ChatId chatId;

  @Nullable
  public DtoNotificationSetting notificationSetting;
}
