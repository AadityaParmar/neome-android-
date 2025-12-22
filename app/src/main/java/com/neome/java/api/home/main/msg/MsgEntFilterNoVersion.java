// neome.ai API - do not change
//

package com.neome.java.api.home.main.msg;

import com.neome.java.api.meta.base.Types.EntId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgEntFilterNoVersion extends Msg
{
  @Nullable
  public Set<EntId> filterEntIdSet;
}
