// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.AnyTime;
import com.neome.java.api.meta.base.Types.EnumDefnDay;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioBuildRepeatSettingWeeks extends StudioBuildRepeatSetting
{
  @Nullable
  public EnumDefnDay[] setOfRepeatDay;

  @Nullable
  public AnyTime[] setOfTime;
}
