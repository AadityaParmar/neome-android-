// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdHeader;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoTableHeader;

@SuppressWarnings("unused")
public class StudioMapOfTableHeader extends StudioBase
{
  public MetaIdHeader[] keys;

  public Map<MetaIdHeader, StudioDtoTableHeader> map;
}
