// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdHeader;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfTableHeader extends StudioBase
{
  public MetaIdHeader[] keys;

  public Map<MetaIdHeader, StudioDtoTableHeader> map;
}
