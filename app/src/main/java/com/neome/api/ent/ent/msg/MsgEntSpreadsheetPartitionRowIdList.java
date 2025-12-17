// neome.ai API - do not change
//

package com.neome.api.ent.ent.msg;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgEntSpreadsheetPartitionRowIdList extends Msg
{
  public long pageSize;

  public MetaIdSpreadsheet spreadsheetId;

  public String toRowOrderVer;
}