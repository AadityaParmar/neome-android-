// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdTableStyle;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfTableStyle extends StudioBase
{
  public MetaIdTableStyle[] keys;

  public Map<MetaIdTableStyle, StudioDtoTableStyle> map;
}
