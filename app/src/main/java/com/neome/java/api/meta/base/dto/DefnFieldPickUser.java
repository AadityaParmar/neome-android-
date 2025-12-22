// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldPickUser extends DefnFieldEditable
{
  @Nullable
  public MetaIdVar dataSourceVarId;

  @Nullable
  public MetaIdRole defaultValue;

  @Nullable
  public MetaIdField defaultValueFieldId;

  @Nullable
  public DefnDtoPluginApi pluginApi;

  @Nullable
  public MetaIdField pluginErrorFieldId;

  @Nullable
  public MetaIdRole[] roleIdDataSource;

  @Nullable
  public FieldSetOfEntUserId setOfEntUserId;

  @Nullable
  public Boolean showAsDropdown;

  @Nullable
  public MetaIdField showAsDropdownFieldId;

  @Nullable
  public Boolean showAsDropdownVar;
}
