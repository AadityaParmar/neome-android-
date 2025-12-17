// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntGroup
{
  public DtoEntGroupActionPermissionMap actionPermissionMap;

  @Nullable
  public Boolean freeze;

  @Nullable
  public EnumDefnFreezeAvatarKind freezeAvatarKind;

  @Nullable
  public String freezeSortName;

  @Nullable
  public MetaIdRole[] removeMessagePermissionSet;
}
