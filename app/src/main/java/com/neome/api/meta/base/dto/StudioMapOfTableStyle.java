// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdTableStyle;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoTableStyle;

@SuppressWarnings("unused")
public class StudioMapOfTableStyle extends StudioBase
{
  public MetaIdTableStyle[] keys;

  public Map<MetaIdTableStyle, StudioDtoTableStyle> map;
}
