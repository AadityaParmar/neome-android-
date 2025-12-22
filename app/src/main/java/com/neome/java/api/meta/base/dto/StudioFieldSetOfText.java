// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemePickMultiVariant;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldSetOfText extends StudioFieldEditable
{
  @Nullable
  public String[] defaultValue;

  @Nullable
  public MetaIdField defaultValueFieldId;

  @Nullable
  public StudioMapOfOptionPermission optionPermissionMap;

  @Nullable
  public StudioDtoPluginApi pluginApi;

  @Nullable
  public MetaIdField pluginErrorFieldId;

  @Nullable
  public MetaIdVar pluginInputMappingVarId;

  @Nullable
  public EnumDefnThemePickMultiVariant showAs;

  @Nullable
  public StudioMapOfOption source;

  @Nullable
  public MetaIdField sourceFieldId;

  @Nullable
  public MetaIdVar sourceVarId;
}
