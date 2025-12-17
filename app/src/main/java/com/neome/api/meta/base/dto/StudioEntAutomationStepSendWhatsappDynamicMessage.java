// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendWhatsappDynamicMessage
  extends StudioEntAutomationStepSendMessageBase
{
  @Nullable
  public MetaIdField dataSourceFieldId;

  @Nullable
  public StudioValueVarIdParagraph messageVarId;
}
