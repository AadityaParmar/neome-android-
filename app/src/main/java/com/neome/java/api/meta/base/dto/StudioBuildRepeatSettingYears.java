// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.AnyTime;
import com.neome.java.api.meta.base.Types.EnumDefnDateOccurrence;
import com.neome.java.api.meta.base.Types.EnumDefnMonth;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioBuildRepeatSettingYears extends StudioBuildRepeatSetting
{
  @Nullable
  public int[] customDateSet;

  @Nullable
  public EnumDefnDateOccurrence dateOccurrence;

  @Nullable
  public EnumDefnMonth[] setOfMonth;

  @Nullable
  public AnyTime[] setOfTime;
}
