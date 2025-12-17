// neome.ai API - do not change
//

package com.neome.api.ent.ent.msg;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgEntSpreadsheetState extends Msg
{
  @Nullable
  public String gridVer;

  public MetaIdSpreadsheet spreadsheetId;
}
