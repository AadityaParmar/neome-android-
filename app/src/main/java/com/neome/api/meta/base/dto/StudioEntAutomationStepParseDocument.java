// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepParseDocument extends StudioEntAutomationStep
{
  @Nullable
  public String aiInstructions;

  @Nullable
  public MetaIdField documentFieldId;

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
  public MetaIdVar outputMappingVarId;

  @Nullable
  public MetaIdForm schemaFormId;
}
