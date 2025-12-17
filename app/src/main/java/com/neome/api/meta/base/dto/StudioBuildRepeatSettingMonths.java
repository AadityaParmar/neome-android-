// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.AnyTime;
import com.neome.api.meta.base.Types.EnumDefnDateOccurrence;
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting;

@SuppressWarnings("unused")
public class StudioBuildRepeatSettingMonths extends StudioBuildRepeatSetting
{
  @Nullable
  public int[] customDateSet;

  @Nullable
  public EnumDefnDateOccurrence dateOccurrence;

  @Nullable
  public AnyTime[] setOfTime;
}
