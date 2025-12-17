// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdLayoutUser;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgUserActionExecute extends Msg
{
  public MetaIdAction actionId;

  public MetaIdLayoutUser layoutId;
}