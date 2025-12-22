// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemePickVariant;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldPickText extends DefnFieldEditable
{
  @Nullable
  public MetaIdField defaultOptionFieldId;

  @Nullable
  public String defaultOptionId;

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
  public EnumDefnThemePickVariant showAs;
}
