// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.RowId;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgSpreadsheetRowsPageGet extends Msg
{
  public MetaIdAction actionId;

  @Nullable
  public Boolean ascOrder;

  @Nullable
  public SpreadsheetFilterComposite filterValue;

  @Nullable
  public Boolean includeFilters;

  @Nullable
  public MetaIdComposite inputFormCompositeId;

  @Nullable
  public RowId inputFormGridRowId;

  @Nullable
  public FormValueRaw inputFormValueRaw;

  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public MetaIdField orderByFieldId;

  @Nullable
  public Long pageNumber;

  @Nullable
  public Long pageSize;

  @Nullable
  public String searchText;
}
