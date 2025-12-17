// neome.ai API - do not change
//

package com.neome.api.app.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoNeoScriptLayoutSpreadsheet extends DtoNeoScript
{
  @Nullable
  public MetaIdSpreadsheet spreadsheetId;

  @Nullable
  public MetaIdLayoutGrid spreadsheetLayoutId;
}
