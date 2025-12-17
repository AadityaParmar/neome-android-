// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldPickRole extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultRoleFieldId;

  @Nullable
  public MetaIdRole defaultRoleId;

  @Nullable
  public EnumDefnThemePickVariant showAs;
}
