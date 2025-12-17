// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.MetaIdEvent;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioEntAutomationStepMap;
import com.neome.api.meta.base.dto.StudioEntPipelineVarMap;
import com.neome.api.meta.base.dto.StudioValueVarIdCondition;
import com.neome.api.meta.base.Symbol;

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
