// neome.ai API - do not change
//

package com.neome.api.app.ai.msg;

import com.neome.api.app.base.dto.DtoNeoScript;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgAiNeoScriptGen extends Msg
{
  public DtoNeoScript dtoNeoScript;

  public String userMessage;
}