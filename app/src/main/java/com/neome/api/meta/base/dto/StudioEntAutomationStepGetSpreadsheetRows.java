// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepGetSpreadsheetRows extends StudioEntAutomationStep
{
  @Nullable
  public Boolean ascOrder;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition iterateOnGridFilterVarId;

  @Nullable
  public MetaIdGrid iterateOnGridId;

  @Nullable
  public Long maxRecords;

  @Nullable
  public MetaIdPipelineParam outputFormPipelineVarId;

  @Nullable
  public MetaIdField sortByFieldId;

  @Nullable
  public StudioValueVarIdCondition targetSpreadsheetFilterVarId;

  @Nullable
  public MetaIdSpreadsheet targetSpreadsheetId;

  @Nullable
  public MetaIdVar targetToSourceMappingVarId;
}
