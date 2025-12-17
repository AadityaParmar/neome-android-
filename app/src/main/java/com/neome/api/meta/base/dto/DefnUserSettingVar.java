// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnUserSettingVar
{
  @Nullable
  public String description;

  public EnumDefnUserSettingOptions kind;

  @Nullable
  public String label;

  public Symbol name;

  @Nullable
  public DefnStudioMapOfDtoOption optionMap;

  public MetaIdVar varId;
}
