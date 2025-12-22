// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnMapOfRefTarget
{
  public MetaIdSpreadsheet[] keys;

  public Map<MetaIdSpreadsheet, DefnDtoRefTarget> map;
}
