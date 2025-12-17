// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendMessageBase extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdRole[] dataSourceRoleIdSet;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition iterateOnGridFilterVarId;

  @Nullable
  public MetaIdGrid iterateOnGridId;

  @Nullable
  public MetaIdVar setOfUserVarId;

  @Nullable
  public MetaIdPipelineParam targetDataSourcePipelineVarId;
}
