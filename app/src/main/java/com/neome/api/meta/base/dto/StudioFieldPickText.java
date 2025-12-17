// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldPickText extends StudioFieldEditable
{
  @Nullable
  public MetaIdField defaultOptionFieldId;

  @Nullable
  public String defaultOptionId;

  @Nullable
  public StudioMapOfOptionPermission optionPermissionMap;

  @Nullable
  public StudioDtoPluginApi pluginApi;

  @Nullable
  public MetaIdField pluginErrorFieldId;

  @Nullable
  public MetaIdVar pluginInputMappingVarId;

  @Nullable
  public EnumDefnThemePickVariant showAs;

  @Nullable
  public StudioMapOfOption source;

  @Nullable
  public MetaIdField sourceFieldId;

  @Nullable
  public MetaIdVar sourceVarId;
}
