// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.EntVdAi;
import com.neome.api.meta.base.Types.EnumDefnSortOrder;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter;
import com.neome.api.meta.base.dto.StudioMapOfCondition;

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
