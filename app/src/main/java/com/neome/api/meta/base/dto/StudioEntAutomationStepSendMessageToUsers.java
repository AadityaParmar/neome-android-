// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendMessageToUsers
  extends StudioEntAutomationStepSendMessageWithSenderField
{
  @Nullable
  public MetaIdRole[] dataSourceRoleIdSet;

  @Nullable
  public MetaIdVar setOfUserVarId;

  @Nullable
  public MetaIdPipelineParam targetUserDataSourcePipelineVarId;
}
