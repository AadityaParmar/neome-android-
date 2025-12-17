// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindSetOfUser;
import com.neome.api.meta.base.Types.EnumDefnUserContext;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoUserConditionStatement extends StudioBase
{
  @Nullable
  public MetaIdRole[] derivedRoleIdSet;

  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public EnumDefnKindSetOfUser kind;

  @Nullable
  public MetaIdRole[] roleIdSet;

  @Nullable
  public EnumDefnUserContext[] userContextSet;
}
