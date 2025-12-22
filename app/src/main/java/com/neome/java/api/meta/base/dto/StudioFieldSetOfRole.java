// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemePickMultiVariant;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldSetOfRole extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultRoleFieldId;

  @Nullable
  public MetaIdRole[] defaultRoleIdSet;

  @Nullable
  public EnumDefnThemePickMultiVariant showAs;
}
