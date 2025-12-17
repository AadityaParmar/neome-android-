// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdGroup;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendMessageToGroups
  extends StudioEntAutomationStepSendMessageWithSenderField
{
  @Nullable
  public MetaIdGroup[] groupIdSet;
}
