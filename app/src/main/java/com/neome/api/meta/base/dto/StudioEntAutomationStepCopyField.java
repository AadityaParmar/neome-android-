// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepCopyField extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdVar mappingVarId;

  @Nullable
  public StudioValueVarIdCondition sourceGridFilterVarId;

  @Nullable
  public MetaIdGrid sourceGridId;

  @Nullable
  public MetaIdPipelineParam sourcePipelineVarId;

  @Nullable
  public MetaIdPipelineParam targetPipelineVarId;
}
