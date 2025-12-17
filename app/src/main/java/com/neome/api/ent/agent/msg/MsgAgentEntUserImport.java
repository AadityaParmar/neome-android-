// neome.ai API - do not change
//

package com.neome.api.ent.agent.msg;

import com.neome.api.ent.base.dto.DtoAgentEntUserImport;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgAgentEntUserImport extends Msg
{
  @Nullable
  public Boolean ignoreManager;

  @Nullable
  public Boolean ignoreUserSettings;

  public DtoAgentEntUserImport[] users;
}
