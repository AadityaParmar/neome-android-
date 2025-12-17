// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class FieldValueVoice extends FieldValueAudio
{
  @Nullable
  public FieldValueLocation captureLocation;

  @Nullable
  public Date captureTime;

  @Nullable
  public FieldValueEntUserId captureUser;
}
