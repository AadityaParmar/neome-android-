// neome.ai API - do not change
//

package com.neome.java.api.ent.entAside.msg;

import com.neome.java.api.ent.base.dto.SpreadsheetFilterComposite;
import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowsGet extends Msg
{
  public MetaIdAction actionId;

  @Nullable
  public Boolean ascOrder;

  @Nullable
  public MetaIdField dateFieldId;

  @Nullable
  public SpreadsheetFilterComposite filterValue;

  @Nullable
  public MetaIdField groupByFieldId;

  @Nullable
  public MetaIdComposite inputFormCompositeId;

  @Nullable
  public RowId inputFormGridRowId;

  @Nullable
  public FormValueRaw inputFormValueRaw;

  @Nullable
  public String searchText;

  @Nullable
  public MetaIdField[] sortByFieldIdSet;

  public MetaIdSpreadsheet spreadsheetId;
}
