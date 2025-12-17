// neome.ai API - do not change
//

package com.neome.api.app.ai.msg;

import com.neome.api.app.base.Types.EnumKindAiAssist;
import com.neome.api.meta.base.Types.MetaId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgAiNeoScriptGet extends Msg
{
  public EnumKindAiAssist kind;

  public String neoScriptOrUserMessage;

  @Nullable
  public MetaId[] paramPath;
}
