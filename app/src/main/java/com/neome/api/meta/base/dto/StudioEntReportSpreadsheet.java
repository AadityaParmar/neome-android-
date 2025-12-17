// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntReportSpreadsheet extends StudioEntReport
{
  @Nullable
  public Boolean ascOrder;

  @Nullable
  public StudioValueVarIdCondition filterConditionVarId;

  @Nullable
  public MetaIdSpreadsheet fromSpreadsheetId;

  @Nullable
  public Long limit;

  @Nullable
  public MetaIdField orderByFieldId;

  @Nullable
  public MetaIdVar outputFormMappingVarId;
}
