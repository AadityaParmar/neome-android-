// neome.ai API - do not change
//

package com.neome.api.home.drawer.msg;

import com.neome.api.meta.base.Types.EntId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgDrawerSearch extends Msg
{
  @Nullable
  public Set<EntId> filterEntIdSet;

  @Nullable
  public Long pageSize;

  public String searchId;

  public String searchQuery;
}
