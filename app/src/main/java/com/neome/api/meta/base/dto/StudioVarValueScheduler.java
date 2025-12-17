// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.TimeZoneKey;

import org.jetbrains.annotations.Nullable;

import java.util.Date;

@SuppressWarnings("unused")
public class StudioVarValueScheduler
{
  @Nullable
  public StudioBuildRepeatSetting repeatSetting;

  @Nullable
  public Date startDateTime;

  @Nullable
  public TimeZoneKey timeZone;
}
