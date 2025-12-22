// neome.ai API - do not change
//

package com.neome.java.api.core.base.dto;

import com.neome.java.api.meta.base.Types.DeviceId;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class DtoDevice
{
  public Date creationTime;

  public DeviceId deviceId;

  @Nullable
  public String deviceName;

  @Nullable
  public Boolean isCurrentDevice;

  @Nullable
  public Boolean isOnline;

  @Nullable
  public Date lastOnlineTime;

  public Object state;
}
