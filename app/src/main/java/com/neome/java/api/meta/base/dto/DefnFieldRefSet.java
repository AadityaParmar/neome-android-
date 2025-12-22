// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnEjectionPolicy;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldRefSet extends DefnFieldEditable
{
  @Nullable
  public Boolean allowDuplicateValues;

  @Nullable
  public MetaIdField displayFieldId;

  @Nullable
  public EnumDefnEjectionPolicy ejectionPolicy;

  @Nullable
  public DefnLayoutGrid layoutSpreadsheet;

  @Nullable
  public Long maxSize;

  public MetaIdSpreadsheet spreadsheetId;
}
