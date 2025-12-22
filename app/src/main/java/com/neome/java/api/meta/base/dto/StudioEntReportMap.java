// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdReport;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntReportMap extends StudioBase
{
  public MetaIdReport[] keys;

  public Map<MetaIdReport, StudioEntReport> map;
}
