// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAction;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.RowId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntSpreadsheetExportExcel
{
  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public RowId[] rowIdSet;

  public MetaIdAction spreadsheetEditorActionId;
}
