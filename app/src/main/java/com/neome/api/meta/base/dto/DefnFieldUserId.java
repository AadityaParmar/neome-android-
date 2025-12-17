// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnRowProperty;
import com.neome.api.meta.base.Types.EnumDefnUserProperty;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldUserId extends DefnFieldEditable
{
  @Nullable
  public EnumDefnRowProperty defaultValue;

  @Nullable
  public EnumDefnUserProperty displayProperty;
}
