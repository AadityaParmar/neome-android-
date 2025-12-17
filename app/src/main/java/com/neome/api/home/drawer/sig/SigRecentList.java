// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.home.base.dto.DtoRecentItem;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigRecentList extends Sig
{
  public DtoRecentItem[] recentList;

  @Nullable
  public String version;
}
