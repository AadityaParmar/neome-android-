// neome.ai API - do not change
//

package com.neome.api.core.base.msg;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EntUserId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgEntUserIdSet extends Msg
{
  @Nullable
  public EntUserId entUserId;

  @Nullable
  public EntUserId[] entUserIdSet;
}
