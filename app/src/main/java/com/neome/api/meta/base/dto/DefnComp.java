// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnCompType;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnComp
{
  @Nullable
  public Boolean disabled;

  @Nullable
  public MetaIdField disabledFieldId;

  @Nullable
  public MetaIdRole[] disabledRoleIdSet;

  @Nullable
  public Boolean disabledVar;

  @Nullable
  public Boolean hidden;

  @Nullable
  public Boolean hideDirtyIndicator;

  @Nullable
  public Boolean invisible;

  @Nullable
  public String label;

  @Nullable
  public Long maxWidth;

  public Symbol name;

  @Nullable
  public Long pb;

  @Nullable
  public DefnDtoPermissionMatrix permissionMatrix;

  @Nullable
  public Long pl;

  @Nullable
  public Long pr;

  @Nullable
  public Long pt;

  @Nullable
  public Boolean readOnly;

  public EnumDefnCompType type;
}
