// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutXYChart extends StudioDtoLayoutGrid
{
  @Nullable
  public Boolean hideLegend;

  @Nullable
  public MetaIdField xAxis;

  @Nullable
  public StudioMapOfChartXAxis xAxisMap;

  @Nullable
  public StudioMapOfChartYAxis yAxisMap;
}
