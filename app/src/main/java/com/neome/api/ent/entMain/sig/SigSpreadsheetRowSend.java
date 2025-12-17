// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.Types.SpreadsheetPartitionId;
import com.neome.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigSpreadsheetRowSend extends Sig
{
  public MetaIdForm formId;

  public RowId rowId;

  public MetaIdSpreadsheet spreadsheetId;

  public SpreadsheetPartitionId spreadsheetPartitionId;
}
