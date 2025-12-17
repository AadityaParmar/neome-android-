// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnEjectionPolicy;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldRefSet extends StudioFieldEditable
{
  @Nullable
  public Boolean allowDuplicateValues;

  @Nullable
  public MetaIdField displayFieldId;

  @Nullable
  public EnumDefnEjectionPolicy ejectionPolicy;

  @Nullable
  public StudioValueVarIdCondition filterConditionVarId;

  @Nullable
  public MetaIdLayoutGrid layoutSpreadsheetId;

  @Nullable
  public Long maxSize;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
