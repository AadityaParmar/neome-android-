// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base.msg;

import com.neome.java.api.meta.base.Types.DeviceId;
import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.meta.base.Types.MediaId;
import com.neome.java.api.meta.base.Types.RequestId;
import com.neome.java.api.meta.base.Types.UserId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgMediaRequest extends Msg
{
  @Nullable
  public DeviceId callerDeviceId;

  @Nullable
  public UserId callerId;

  @Nullable
  public String cmd;

  @Nullable
  public EntId entId;

  @Nullable
  public EntUserId entUserId;

  @Nullable
  public Long expiry;

  @Nullable
  public String fileName;

  @Nullable
  public Long length;

  @Nullable
  public MediaId mediaId;

  @Nullable
  public Long offset;

  @Nullable
  public RequestId requestId;
}
