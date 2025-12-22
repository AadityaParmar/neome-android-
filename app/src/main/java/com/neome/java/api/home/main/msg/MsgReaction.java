// neome.ai API - do not change
//

package com.neome.java.api.home.main.msg;

import com.neome.java.api.core.base.dto.DtoChatMessageOffset;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgReaction extends MsgOffset
{
  @Nullable
  public DtoChatMessageOffset chatMessageOffset;

  @Nullable
  public String reaction;
}
