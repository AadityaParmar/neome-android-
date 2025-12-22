// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.msg;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.meta.base.Types.RowId;

import java.util.Map;

@SuppressWarnings("unused")
public class MsgSpreadsheetBulkRowCommentCountGet extends MsgVersion
{
  public Map<RowId, String> rowIdCommentVersionMap;
}
