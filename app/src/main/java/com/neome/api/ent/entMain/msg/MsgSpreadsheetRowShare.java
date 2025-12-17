// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowShare extends Msg
{
  @Nullable
  public Boolean reset;

  public RowId rowId;

  public MetaIdSpreadsheet spreadsheetId;
}
