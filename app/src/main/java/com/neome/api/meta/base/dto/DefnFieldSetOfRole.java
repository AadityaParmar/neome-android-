// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldSetOfRole extends DefnFieldEditable
{
  @Nullable
  public Boolean allowSystemRoles;

  @Nullable
  public DefnStudioMapOfDtoOption callerRoleMap;

  @Nullable
  public MetaIdField defaultRoleFieldId;

  @Nullable
  public MetaIdRole[] defaultRoleIdSet;

  @Nullable
  public MetaIdRole[] excludeRoleIdSet;

  @Nullable
  public MetaIdRole[] filterRoleIdSet;

  @Nullable
  public DefnStudioMapOfDtoOption includeOptionMap;

  @Nullable
  public Long pageSize;

  @Nullable
  public EnumDefnThemePickMultiVariant showAs;
}
