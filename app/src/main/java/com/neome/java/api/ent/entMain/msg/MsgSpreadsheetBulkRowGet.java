// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.nucleus.base.msg.Msg;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgSpreadsheetBulkRowGet extends Msg
{
  public Map<RowId, String> rowIdVersionMap;

  public MetaIdSpreadsheet spreadsheetId;
}
