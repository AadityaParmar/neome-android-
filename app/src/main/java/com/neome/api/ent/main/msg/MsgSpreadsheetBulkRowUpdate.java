// neome.ai API - do not change
//

package com.neome.api.ent.main.msg;

import com.google.gson.JsonElement;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.nucleus.base.msg.Msg;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgSpreadsheetBulkRowUpdate extends Msg
{
  public MetaIdAction actionId;

  public RowId[] rowIdSet;

  public Map<MetaIdComp, JsonElement> valueMap;
}
