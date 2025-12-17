// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPermission;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioDtoPermissionMatrix extends StudioBase
{
  @Nullable
  public EnumDefnPermission defaultPermission;

  public MetaIdRole[] keys;

  public Map<MetaIdRole, EnumDefnPermission> map;
}
