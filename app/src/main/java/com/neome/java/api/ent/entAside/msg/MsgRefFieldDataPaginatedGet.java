// neome.ai API - do not change
//

package com.neome.java.api.ent.entAside.msg;

import com.neome.java.api.ent.base.dto.SpreadsheetFilterComposite;
import com.neome.java.api.meta.base.Types.MetaIdComp;
import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.RowId;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class MsgRefFieldDataPaginatedGet extends Msg
{
  @Nullable
  public Boolean ascOrder;

  @Nullable
  public SpreadsheetFilterComposite filterValue;

  public MetaIdForm formId;

  @Nullable
  public Boolean includeFilters;

  @Nullable
  public MetaIdComposite inputFormCompositeId;

  @Nullable
  public RowId inputFormGridRowId;

  public FormValueRaw inputFormValueRaw;

  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public MetaIdField orderByFieldId;

  @Nullable
  public Long pageNumber;

  @Nullable
  public Long pageSize;

  public MetaIdComp refFieldId;

  @Nullable
  public String searchText;

  @Nullable
  public MetaIdSpreadsheet targetSpreadsheetId;
}
