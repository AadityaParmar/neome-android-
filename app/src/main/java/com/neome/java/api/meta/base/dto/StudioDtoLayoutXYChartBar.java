// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnChartRenderingMode;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutXYChartBar extends StudioDtoLayoutXYChart
{
  @Nullable
  public Boolean alwaysShowBarValues;

  @Nullable
  public EnumDefnChartRenderingMode renderingMode;
}
