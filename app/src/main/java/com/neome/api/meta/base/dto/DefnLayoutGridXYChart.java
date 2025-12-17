// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutGridXYChart extends DefnLayoutGrid
{
  @Nullable
  public Boolean hideLegend;

  public MetaIdField xAxis;

  @Nullable
  public DefnStudioMapOfChartXAxis xAxisMap;

  @Nullable
  public DefnStudioMapOfChartYAxis yAxisMap;
}
