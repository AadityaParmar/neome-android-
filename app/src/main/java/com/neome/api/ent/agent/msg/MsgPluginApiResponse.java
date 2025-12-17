// neome.ai API - do not change
//

package com.neome.api.ent.agent.msg;

import com.neome.api.meta.base.Types.RequestId;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.dto.EnvError;
import com.neome.api.nucleus.base.msg.Msg;

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
