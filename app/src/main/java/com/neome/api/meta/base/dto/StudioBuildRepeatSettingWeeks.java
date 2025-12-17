// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.AnyTime;
import com.neome.api.meta.base.Types.EnumDefnDay;
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting;

@SuppressWarnings("unused")
public class StudioBuildRepeatSettingWeeks extends StudioBuildRepeatSetting
{
  @Nullable
  public EnumDefnDay[] setOfRepeatDay;

  @Nullable
  public AnyTime[] setOfTime;
}
