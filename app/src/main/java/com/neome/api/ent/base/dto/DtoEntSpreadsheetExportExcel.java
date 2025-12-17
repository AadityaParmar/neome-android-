// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.RowId;

@SuppressWarnings("unused")
public class DtoEntSpreadsheetExportExcel
{
  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public RowId[] rowIdSet;

  public MetaIdAction spreadsheetEditorActionId;
}
