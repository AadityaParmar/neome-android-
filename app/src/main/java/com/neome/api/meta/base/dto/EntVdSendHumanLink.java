// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindChannelType;
import com.neome.api.meta.base.Types.MetaIdPipelineParam;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSendHumanLink extends EntVdAutoStepWithOutputAndError
{
  @Nullable
  public MetaIdPipelineParam embedFormParamId;

  @Nullable
  public FieldDtoDuration expiryDatetime;

  @Nullable
  public StudioBuildArgBinder fromHandle;

  @Nullable
  public Long maxClicks;

  @Nullable
  public StudioValueParagraph message;

  @Nullable
  public Long reminders;

  @Nullable
  public StudioBuildArgBinder sender;

  @Nullable
  public EnumDefnKindChannelType[] targetChannels;

  @Nullable
  public StudioValueText title;

  @Nullable
  public StudioBuildArgBinder toHandle;
}
