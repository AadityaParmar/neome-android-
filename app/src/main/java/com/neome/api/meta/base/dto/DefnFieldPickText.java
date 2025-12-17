// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnDtoPluginApi;
import com.neome.api.meta.base.dto.DefnFieldEditable;
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption;
import com.neome.api.meta.base.dto.DefnStudioMapOfOptionPermission;
import com.neome.api.meta.base.Types.EnumDefnThemePickVariant;
import com.neome.api.meta.base.Types.MetaIdField;

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
