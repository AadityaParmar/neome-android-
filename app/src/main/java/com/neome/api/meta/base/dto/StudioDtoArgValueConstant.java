// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnCompType;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoArgValueConstant extends StudioDtoArgValue
{
  public EnumDefnCompType type;

  @Nullable
  public Object value;
}
