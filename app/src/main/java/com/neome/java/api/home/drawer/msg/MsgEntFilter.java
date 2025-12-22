// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.msg;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.meta.base.Types.EntId;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgEntFilter extends MsgVersion
{
  @Nullable
  public Set<EntId> filterEntIdSet;
}
