// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdFooter;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoTableFooter;

@SuppressWarnings("unused")
public class StudioMapOfTableFooter extends StudioBase
{
  public MetaIdFooter[] keys;

  public Map<MetaIdFooter, StudioDtoTableFooter> map;
}
