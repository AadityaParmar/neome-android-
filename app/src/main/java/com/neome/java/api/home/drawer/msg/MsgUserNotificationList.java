// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.msg;

import com.neome.java.api.core.base.msg.MsgVersion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgUserNotificationList extends MsgVersion
{
  @Nullable
  public Long limit;

  @Nullable
  public Long offset;
}
