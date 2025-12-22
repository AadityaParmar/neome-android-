// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumStudioCompType;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioComp extends StudioBase
{
  @Nullable
  public String aiInstructions;

  public StudioDetails details;

  @Nullable
  public Boolean disabled;

  @Nullable
  public MetaIdField disabledFieldId;

  @Nullable
  public MetaIdRole[] disabledRoleIdSet;

  @Nullable
  public MetaIdVar disabledVarId;

  @Nullable
  public StudioDtoPermissionMatrix permissionMatrix;

  @Nullable
  public EnumStudioCompType type;
}
