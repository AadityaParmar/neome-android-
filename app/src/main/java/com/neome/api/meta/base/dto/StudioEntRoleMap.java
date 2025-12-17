// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioEntRole;

@SuppressWarnings("unused")
public class StudioEntRoleMap extends StudioBase
{
  public MetaIdRole[] keys;

  public Map<MetaIdRole, StudioEntRole> map;
}
