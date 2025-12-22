// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemePickVariant;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldPickRole extends DefnFieldEditable
{
  @Nullable
  public Boolean allowSystemRoles;

  @Nullable
  public DefnStudioMapOfDtoOption callerRoleMap;

  @Nullable
  public MetaIdField defaultRoleFieldId;

  @Nullable
  public MetaIdRole defaultRoleId;

  @Nullable
  public MetaIdRole[] excludeRoleIdSet;

  @Nullable
  public MetaIdRole[] filterRoleIdSet;

  @Nullable
  public DefnStudioMapOfDtoOption includeOptionMap;

  @Nullable
  public Long pageSize;

  @Nullable
  public EnumDefnThemePickVariant showAs;
}
