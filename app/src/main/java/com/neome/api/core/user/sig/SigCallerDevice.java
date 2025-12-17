// neome.ai API - do not change
//

package com.neome.api.core.user.sig;

import com.neome.api.meta.base.Types.DeviceId;
import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class SigCallerDevice extends SigVersion
{
  public Date creationTime;

  public DeviceId deviceId;

  @Nullable
  public String deviceName;

  @Nullable
  public String deviceToken;

  public String randomColor;

  public Date refreshTokenExpiry;
}
