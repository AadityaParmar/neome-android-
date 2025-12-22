// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetHistoryGet extends Msg
{
  @Nullable
  public String offset;

  @Nullable
  public Long pageSize;

  @Nullable
  public RowId rowId;

  @Nullable
  public String searchText;

  public MetaIdSpreadsheet spreadsheetId;
}
