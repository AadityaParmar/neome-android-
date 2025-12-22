// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendWhatsappTemplateMessage
  extends StudioEntAutomationStepSendMessageBase
{
  @Nullable
  public StudioMapOfVarIdText carouselCardMessageVarMap;

  @Nullable
  public MetaIdField dataSourceFieldId;

  @Nullable
  public MetaIdField mediaFieldId;

  @Nullable
  public StudioMapOfVarIdText messageVarMap;

  @Nullable
  public String templateGroupId;
}
