// neome.ai API - do not change
//

package com.neome.java.api.core.base.msg;

import com.neome.java.api.meta.base.Types.EntUserId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgEntUserIdSet extends Msg
{
  @Nullable
  public EntUserId entUserId;

  @Nullable
  public EntUserId[] entUserIdSet;
}
