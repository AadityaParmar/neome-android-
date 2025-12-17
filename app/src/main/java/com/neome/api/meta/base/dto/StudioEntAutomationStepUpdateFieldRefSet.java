// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnRefSetOperationKind;
import com.neome.api.meta.base.Types.EnumDefnSortOrder;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepUpdateFieldRefSet extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition iterateOnGridFilterVarId;

  @Nullable
  public MetaIdGrid iterateOnGridId;

  @Nullable
  public EnumDefnRefSetOperationKind operation;

  @Nullable
  public MetaIdPipelineParam outputFormPipelineVarId;

  @Nullable
  public EnumDefnSortOrder sortOrder;

  @Nullable
  public MetaIdField sourceFieldId;

  @Nullable
  public MetaIdField targetFieldId;
}
