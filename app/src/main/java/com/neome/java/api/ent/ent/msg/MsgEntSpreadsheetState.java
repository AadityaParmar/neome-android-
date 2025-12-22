// neome.ai API - do not change
//

package com.neome.java.api.ent.ent.msg;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgEntSpreadsheetState extends Msg
{
  @Nullable
  public String gridVer;

  public MetaIdSpreadsheet spreadsheetId;
}
