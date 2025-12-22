// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdVar;

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
