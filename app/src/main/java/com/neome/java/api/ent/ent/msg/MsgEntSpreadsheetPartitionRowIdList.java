// neome.ai API - do not change
//

package com.neome.java.api.ent.ent.msg;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgEntSpreadsheetPartitionRowIdList extends Msg
{
  public long pageSize;

  public MetaIdSpreadsheet spreadsheetId;

  public String toRowOrderVer;
}
