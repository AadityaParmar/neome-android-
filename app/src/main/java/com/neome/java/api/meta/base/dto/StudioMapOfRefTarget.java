// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfRefTarget extends StudioBase
{
  public MetaIdSpreadsheet[] keys;

  public Map<MetaIdSpreadsheet, StudioDtoRefTarget> map;
}
