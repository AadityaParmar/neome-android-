// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdEvent;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationEvent extends StudioBase
{
  @Nullable
  public String description;

  @Nullable
  public MetaIdPipelineParam executionConditionInputPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition executionConditionVarId;

  public MetaIdEvent metaId;

  public Symbol name;

  @Nullable
  public StudioEntPipelineVarMap pipelineVarMap;

  @Nullable
  public String secondary;

  public StudioEntAutomationStepMap stepMap;
}
