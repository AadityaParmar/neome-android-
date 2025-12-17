// neome.ai API - do not change
//

package com.neome.api.home.base.dto;

import com.neome.api.home.drawer.sig.SigGroupAvatar;
import com.neome.api.home.drawer.sig.SigUserAvatar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoNewChatCandidate
{
  @Nullable
  public SigGroupAvatar groupAvatar;

  @Nullable
  public SigUserAvatar userAvatar;
}
