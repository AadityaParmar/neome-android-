// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepAddUser extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdField avatarFieldId;

  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition iterateOnGridFilterVarId;

  @Nullable
  public MetaIdGrid iterateOnGridId;

  @Nullable
  public MetaIdField managerFieldId;

  @Nullable
  public MetaIdVar managerVarId;

  @Nullable
  public MetaIdVar outputFormMappingVarId;

  @Nullable
  public MetaIdPipelineParam outputFormPipelineVarId;

  @Nullable
  public MetaIdField userHandleFieldId;

  @Nullable
  public MetaIdField userNameFieldId;

  @Nullable
  public MetaIdField userRoleFieldId;

  @Nullable
  public MetaIdRole[] userRoleIdSet;
}
