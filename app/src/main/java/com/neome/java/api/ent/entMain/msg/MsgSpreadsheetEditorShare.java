// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetEditorShare extends Msg
{
  public MetaIdAction actionId;

  @Nullable
  public Boolean reset;
}
