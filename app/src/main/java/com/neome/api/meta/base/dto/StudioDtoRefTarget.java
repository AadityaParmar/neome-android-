// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoRefTarget extends StudioBase
{
  @Nullable
  public MetaIdField[] displayFieldIdSet;

  @Nullable
  public StudioValueVarIdCondition filterConditionVarId;

  public MetaIdSpreadsheet metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public MetaIdLayoutGrid overrideLayoutSpreadsheetId;
}
