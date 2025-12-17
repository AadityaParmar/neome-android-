// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVideoTimestamp;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnMapOfVideoTimestamp
{
  public MetaIdVideoTimestamp[] keys;

  public Map<MetaIdVideoTimestamp, DefnDtoVideoTimestamp> map;
}
