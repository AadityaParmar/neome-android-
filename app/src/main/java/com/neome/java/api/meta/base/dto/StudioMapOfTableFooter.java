// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdFooter;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfTableFooter extends StudioBase
{
  public MetaIdFooter[] keys;

  public Map<MetaIdFooter, StudioDtoTableFooter> map;
}
