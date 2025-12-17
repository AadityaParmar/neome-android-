// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPermission;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnDtoPermissionMatrix
{
  @Nullable
  public EnumDefnPermission defaultPermission;

  @Nullable
  public MetaIdRole[] keys;

  @Nullable
  public Map<MetaIdRole, EnumDefnPermission> map;
}
