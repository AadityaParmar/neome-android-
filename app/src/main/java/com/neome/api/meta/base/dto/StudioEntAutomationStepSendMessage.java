// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendMessage extends StudioEntAutomationStepSendMessageBase
{
  @Nullable
  public MetaIdGroup[] groupIdSet;

  @Nullable
  public StudioValueVarIdParagraph messageVarId;

  @Nullable
  public Boolean sendAsComment;

  @Nullable
  public MetaIdField senderFieldId;

  @Nullable
  public MetaIdRole senderRoleId;
}
