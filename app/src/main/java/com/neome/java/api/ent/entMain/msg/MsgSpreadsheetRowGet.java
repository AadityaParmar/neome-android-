// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowGet extends MsgVersion
{
  public RowId rowId;

  public MetaIdSpreadsheet spreadsheetId;
}
