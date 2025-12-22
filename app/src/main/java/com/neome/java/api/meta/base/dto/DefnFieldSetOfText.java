// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemePickMultiVariant;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldSetOfText extends DefnFieldEditable
{
  @Nullable
  public String[] defaultValue;

  @Nullable
  public MetaIdField defaultValueFieldId;

  @Nullable
  public MetaIdField optionFieldId;

  @Nullable
  public DefnStudioMapOfDtoOption optionMap;

  @Nullable
  public DefnStudioMapOfOptionPermission optionPermissionMap;

  @Nullable
  public Long pageSize;

  @Nullable
  public DefnDtoPluginApi pluginApi;

  @Nullable
  public MetaIdField pluginErrorFieldId;

  @Nullable
  public EnumDefnThemePickMultiVariant showAs;
}
