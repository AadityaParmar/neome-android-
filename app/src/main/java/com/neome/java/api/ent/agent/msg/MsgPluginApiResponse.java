// neome.ai API - do not change
//

package com.neome.java.api.ent.agent.msg;

import com.neome.java.api.meta.base.Types.RequestId;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.dto.EnvError;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgPluginApiResponse extends Msg
{
  @Nullable
  public EnvError pluginError;

  public RequestId requestId;

  @Nullable
  public FormValueRaw responseFormValue;
}
