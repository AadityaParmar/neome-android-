// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdChartYAxis;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfChartYAxis extends StudioBase
{
  public MetaIdChartYAxis[] keys;

  public Map<MetaIdChartYAxis, StudioDtoChartYAxis> map;
}
