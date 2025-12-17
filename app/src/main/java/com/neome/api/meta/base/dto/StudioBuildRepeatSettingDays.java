// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.AnyTime;
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting;

@SuppressWarnings("unused")
public class StudioBuildRepeatSettingDays extends StudioBuildRepeatSetting
{
  @Nullable
  public AnyTime[] setOfTime;
}
