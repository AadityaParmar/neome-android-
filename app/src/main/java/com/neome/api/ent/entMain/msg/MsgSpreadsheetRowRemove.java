// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowRemove extends Msg
{
  public MetaIdForm formId;

  @Nullable
  public RowId rowId;

  @Nullable
  public RowId[] rowIdSet;

  public MetaIdSpreadsheet spreadsheetId;

  @Nullable
  public String transactionId;
}
