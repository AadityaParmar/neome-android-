// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.sig;

import com.neome.java.api.home.base.dto.DtoRecentItem;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigRecentList extends Sig
{
  public DtoRecentItem[] recentList;

  @Nullable
  public String version;
}
