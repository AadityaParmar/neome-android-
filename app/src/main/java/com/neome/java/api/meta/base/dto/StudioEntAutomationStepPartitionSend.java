// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGroup;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepPartitionSend extends StudioEntAutomationStep
{
  @Nullable
  public StudioDtoChatBubbleHeader chatBubbleHeader;

  @Nullable
  public MetaIdField senderFieldId;

  @Nullable
  public MetaIdPipelineParam senderFormPipelineVarId;

  @Nullable
  public MetaIdRole senderRoleId;

  @Nullable
  public MetaIdGroup[] targetGroupIdSet;

  @Nullable
  public MetaIdSpreadsheet targetSpreadsheetId;
}
