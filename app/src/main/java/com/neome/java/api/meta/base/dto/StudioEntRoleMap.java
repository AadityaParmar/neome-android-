// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdRole;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntRoleMap extends StudioBase
{
  public MetaIdRole[] keys;

  public Map<MetaIdRole, StudioEntRole> map;
}
