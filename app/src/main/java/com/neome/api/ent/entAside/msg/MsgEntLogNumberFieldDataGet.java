// neome.ai API - do not change
//

package com.neome.api.ent.entAside.msg;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgEntLogNumberFieldDataGet extends Msg
{
  public MetaIdField fieldId;

  @Nullable
  public MetaIdGrid gridId;

  @Nullable
  public RowId gridRowId;

  public RowId rowId;

  public MetaIdSpreadsheet spreadsheetId;
}
