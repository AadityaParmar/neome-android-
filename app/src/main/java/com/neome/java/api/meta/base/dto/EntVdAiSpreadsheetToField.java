// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnSortOrder;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdAiSpreadsheetToField extends EntVdAi
{
  @Nullable
  public EnumDefnSortOrder ascendingOrder;

  @Nullable
  public StudioMapOfCondition filterCondition;

  @Nullable
  public Long numberOfRows;

  @Nullable
  public MetaIdField[] orderByFieldIds;

  @Nullable
  public StudioDtoArgValueParameter outputField;

  @Nullable
  public MetaIdField[] selectFieldIds;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
