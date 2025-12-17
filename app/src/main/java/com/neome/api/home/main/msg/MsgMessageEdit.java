// neome.ai API - do not change
//

package com.neome.api.home.main.msg;

import com.neome.api.core.base.dto.DtoChatMessageOffset;
import com.neome.api.home.base.dto.DtoMessagePayload;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgMessageEdit extends MsgOffset
{
  @Nullable
  public DtoChatMessageOffset chatMessageOffset;

  @Nullable
  public DtoMessagePayload dtoMessagePayload;
}
