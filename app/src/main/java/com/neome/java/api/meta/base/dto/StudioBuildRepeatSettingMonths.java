// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.AnyTime;
import com.neome.java.api.meta.base.Types.EnumDefnDateOccurrence;

import org.jetbrains.annotations.Nullable;

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
