// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.core.base.msg.MsgVersion;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.SpreadsheetPartitionId;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowExpiryGet extends MsgVersion
{
  public MetaIdSpreadsheet spreadsheetId;

  public SpreadsheetPartitionId spreadsheetPartitionId;
}
