// neome.ai API - do not change
//

package com.neome.api.core.user.msg;

import com.neome.api.meta.base.Types.EnumDeviceType;
import com.neome.api.meta.base.Types.EnumIdentityProviderKind;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSocialSignIn extends Msg
{
  public String deviceName;

  public EnumDeviceType deviceType;

  public EnumIdentityProviderKind identityProviderKind;

  @Nullable
  public String nickName;

  @Nullable
  public Boolean rememberMe;

  public String token;
}
