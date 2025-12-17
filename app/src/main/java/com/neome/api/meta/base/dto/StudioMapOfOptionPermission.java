// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoOptionPermission;

@SuppressWarnings("unused")
public class StudioMapOfOptionPermission extends StudioBase
{
  public MetaIdRole[] keys;

  public Map<MetaIdRole, StudioDtoOptionPermission> map;
}
