// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdReport;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntReportMap extends StudioBase
{
  public MetaIdReport[] keys;

  public Map<MetaIdReport, StudioEntReport> map;
}
