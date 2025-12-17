// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.FormValueRaw;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowMarkRead extends MsgVersion
{
  public FormValueRaw formValueRaw;

  public RowId rowId;

  public MetaIdSpreadsheet spreadsheetId;
}
