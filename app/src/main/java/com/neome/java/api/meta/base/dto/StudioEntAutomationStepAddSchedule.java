// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdAutomation;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepAddSchedule extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdAutomation automationId;

  @Nullable
  public MetaIdField dateTimeFieldId;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public MetaIdPipelineParam outputFormPipelineVarId;

  @Nullable
  public MetaIdField schedulerFieldId;

  @Nullable
  public MetaIdVar sourceToTargetMappingVarId;
}
