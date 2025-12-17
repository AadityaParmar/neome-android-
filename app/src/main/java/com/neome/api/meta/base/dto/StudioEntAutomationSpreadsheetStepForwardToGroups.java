// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationSpreadsheetStepForwardToGroups extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdRole[] dataSourceRoleIdSet;

  @Nullable
  public MetaIdPipelineParam formDataSourcePipelineVarId;

  @Nullable
  public MetaIdGroup[] groupIdSet;

  @Nullable
  public MetaIdField senderFieldId;

  @Nullable
  public MetaIdPipelineParam senderFormPipelineVarId;

  @Nullable
  public MetaIdRole senderRoleId;

  @Nullable
  public MetaIdVar setOfUserVarId;
}
