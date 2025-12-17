// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPipelineFormKind;
import com.neome.api.meta.base.Types.MetaIdAutomation;
import com.neome.api.meta.base.Types.MetaIdEvent;
import com.neome.api.meta.base.Types.MetaIdPipelineVar;
import com.neome.api.meta.base.Types.MetaIdStep;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickPipelineVarId extends DefnFieldEditable
{
  @Nullable
  public MetaIdEvent automationEventId;

  @Nullable
  public MetaIdAutomation automationId;

  @Nullable
  public MetaIdStep automationStepId;

  @Nullable
  public MetaIdPipelineVar[] excludePipelineVarIdSet;

  @Nullable
  public DefnStudioMapOfDtoOption includeOptionMap;

  @Nullable
  public Boolean multiSelect;

  @Nullable
  public EnumDefnPipelineFormKind pipelineFormKind;
}
