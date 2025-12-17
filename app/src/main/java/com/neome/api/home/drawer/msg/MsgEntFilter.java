// neome.ai API - do not change
//

package com.neome.api.home.drawer.msg;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.meta.base.Types.EntId;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgEntFilter extends MsgVersion
{
  @Nullable
  public Set<EntId> filterEntIdSet;
}
