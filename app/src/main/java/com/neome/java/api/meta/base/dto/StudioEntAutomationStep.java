// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnAutomationTerminateKind;
import com.neome.java.api.meta.base.Types.EnumDefnKindAutomationStep;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdStep;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStep extends StudioBase
{
  @Nullable
  public String description;

  @Nullable
  public MetaIdPipelineParam executionConditionInputPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition executionConditionVarId;

  public EnumDefnKindAutomationStep kind;

  public MetaIdStep metaId;

  public Symbol name;

  @Nullable
  public Boolean skipUpdateSpreadsheetTrigger;

  @Nullable
  public MetaIdField terminateFieldId;

  @Nullable
  public EnumDefnAutomationTerminateKind terminateKind;
}
