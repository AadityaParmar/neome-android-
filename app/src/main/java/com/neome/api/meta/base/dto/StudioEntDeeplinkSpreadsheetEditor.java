// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntDeeplinkSpreadsheetEditor extends StudioEntDeeplinkWithHeader
{
  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
