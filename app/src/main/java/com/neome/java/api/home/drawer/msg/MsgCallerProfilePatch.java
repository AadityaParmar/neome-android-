// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.msg;

import com.neome.java.api.core.base.dto.DtoNotificationSetting;
import com.neome.java.api.meta.base.Types.LanguageKey;
import com.neome.java.api.meta.base.Types.MediaIdAvatar;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgCallerProfilePatch extends Msg
{
  @Nullable
  public String about;

  @Nullable
  public Boolean enterIsSendDesktop;

  @Nullable
  public Boolean enterIsSendMobile;

  public String firstName;

  @Nullable
  public DtoNotificationSetting globalNotificationSetting;

  @Nullable
  public LanguageKey languageKey;

  public String lastName;

  @Nullable
  public MediaIdAvatar mediaIdAvatar;
}
