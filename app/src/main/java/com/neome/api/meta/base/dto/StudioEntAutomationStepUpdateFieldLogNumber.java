// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnLogOperationKind;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepUpdateFieldLogNumber extends StudioEntAutomationStep
{
  @Nullable
  public StudioValueVarIdText customMessageVarId;

  @Nullable
  public EnumDefnLogOperationKind operation;

  @Nullable
  public MetaIdField rowFieldId;

  @Nullable
  public MetaIdPipelineParam sourcePipelineVarId;

  @Nullable
  public MetaIdField targetFieldId;

  @Nullable
  public MetaIdSpreadsheet targetSpreadsheetId;

  @Nullable
  public StudioBuildArgBinderHolder value;
}
