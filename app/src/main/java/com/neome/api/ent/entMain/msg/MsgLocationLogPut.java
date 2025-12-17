// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.EntId;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgLocationLogPut extends Msg
{
  public EntId[] entIdSet;

  public String name;

  public Object summary;
}