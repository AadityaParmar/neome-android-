// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.dto.DefnDtoTableHeader;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdHeader;

@SuppressWarnings("unused")
public class DefnStudioMapOfTableHeader
{
  public MetaIdHeader[] keys;

  public Map<MetaIdHeader, DefnDtoTableHeader> map;
}
