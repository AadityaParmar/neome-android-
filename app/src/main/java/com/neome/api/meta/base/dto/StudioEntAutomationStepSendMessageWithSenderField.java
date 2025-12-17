// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendMessageWithSenderField extends StudioEntAutomationStep
{
  @Nullable
  public MetaIdPipelineParam inputFormPipelineVarId;

  @Nullable
  public StudioValueVarIdCondition iterateOnGridFilterVarId;

  @Nullable
  public MetaIdGrid iterateOnGridId;

  @Nullable
  public StudioValueVarIdParagraph messageVarId;

  @Nullable
  public MetaIdField senderFieldId;

  @Nullable
  public MetaIdRole senderRoleId;
}
