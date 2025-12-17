// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoRefTarget;

@SuppressWarnings("unused")
public class StudioMapOfRefTarget extends StudioBase
{
  public MetaIdSpreadsheet[] keys;

  public Map<MetaIdSpreadsheet, StudioDtoRefTarget> map;
}
