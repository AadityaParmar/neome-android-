// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.core.base.msg.MsgHandle;
import com.neome.api.meta.base.Types.EnumDeviceType;
import com.neome.api.meta.base.Types.LanguageKey;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgAccountCreate extends MsgHandle
{
  public String deviceName;

  public EnumDeviceType deviceType;

  public String firstName;

  @Nullable
  public LanguageKey languageKey;

  public String lastName;

  public String newPassword;
}
