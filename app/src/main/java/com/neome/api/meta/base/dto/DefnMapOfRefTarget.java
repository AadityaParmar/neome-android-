// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnMapOfRefTarget
{
  public MetaIdSpreadsheet[] keys;

  public Map<MetaIdSpreadsheet, DefnDtoRefTarget> map;
}
