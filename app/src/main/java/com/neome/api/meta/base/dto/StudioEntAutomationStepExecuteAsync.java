// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdAutomation;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepExecuteAsync extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdAutomation automationId;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public MetaIdVar sourceToTargetMappingVarId;
}
