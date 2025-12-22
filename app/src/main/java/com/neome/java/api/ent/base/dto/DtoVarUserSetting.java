// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.google.gson.JsonElement;
import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnUserSettingOptions;
import com.neome.java.api.meta.base.Types.MetaIdVar;
import com.neome.java.api.meta.base.dto.DefnStudioMapOfDtoOption;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoVarUserSetting
{
  @Nullable
  public String description;

  public EnumDefnUserSettingOptions kind;

  @Nullable
  public String label;

  public Symbol name;

  @Nullable
  public DefnStudioMapOfDtoOption optionMap;

  @Nullable
  public JsonElement value;

  public MetaIdVar varId;
}
