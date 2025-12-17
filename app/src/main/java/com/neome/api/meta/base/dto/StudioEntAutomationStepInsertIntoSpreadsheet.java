// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepInsertIntoSpreadsheet extends StudioEntAutomationStep
{
  @Nullable
  public Boolean exposeOutputAsPipelineVariable;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition iterateOnGridFilterVarId;

  @Nullable
  public MetaIdGrid iterateOnGridId;

  @Nullable
  public MetaIdPipelineParam outputFormPipelineVarId;

  @Nullable
  public MetaIdVar sourceToTargetMappingVarId;

  @Nullable
  public MetaIdSpreadsheet targetSpreadsheetId;

  @Nullable
  public MetaIdVar targetToSourceMappingVarId;
}
