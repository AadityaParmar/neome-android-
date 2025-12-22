// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnFreezeAvatarKind;
import com.neome.java.api.meta.base.Types.MetaIdRole;

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
