// neome.ai API - do not change
//

package com.neome.java.api.ent.agent.msg;

import com.neome.java.api.ent.base.dto.DtoAgentEntUserImport;
import com.neome.java.api.nucleus.base.msg.Msg;

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
