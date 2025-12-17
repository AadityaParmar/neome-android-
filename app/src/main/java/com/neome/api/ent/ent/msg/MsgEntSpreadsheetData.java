// neome.ai API - do not change
//

package com.neome.api.ent.ent.msg;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgEntSpreadsheetData extends Msg
{
  @Nullable
  public String fromGridVer;

  public long pageSize;

  public MetaIdSpreadsheet spreadsheetId;

  public String toGridVer;
}
