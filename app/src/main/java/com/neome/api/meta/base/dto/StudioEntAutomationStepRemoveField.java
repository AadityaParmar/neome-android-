// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepRemoveField extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdPipelineParam formPipelineVarId;

  @Nullable
  public MetaIdField removeFieldId;
}
