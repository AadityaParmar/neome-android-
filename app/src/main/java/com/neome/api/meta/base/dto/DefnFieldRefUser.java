// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnFieldRefUser extends DefnFieldEditable
{
  @Nullable
  public Map<MetaIdField, MetaIdVar> copyFieldVarMap;

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
}
