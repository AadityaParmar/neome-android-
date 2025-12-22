// neome.ai API - do not change
//

package com.neome.java.api.ent.main.msg;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgSpreadsheetBulkRowInsert extends Msg
{
  public Map<RowId, FormValueRaw> rowMap;

  public MetaIdSpreadsheet spreadsheetId;
}
