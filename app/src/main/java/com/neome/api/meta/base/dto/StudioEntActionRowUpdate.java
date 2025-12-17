// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntActionRowUpdate extends StudioEntAction
{
  @Nullable
  public StudioValueVarIdCondition filterConditionVarId;

  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public MetaIdField lookupFieldId;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
