// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.sig;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.Types.SpreadsheetPartitionId;
import com.neome.java.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigSpreadsheetRowSend extends Sig
{
  public MetaIdForm formId;

  public RowId rowId;

  public MetaIdSpreadsheet spreadsheetId;

  public SpreadsheetPartitionId spreadsheetPartitionId;
}
