// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeColor;
import com.neome.java.api.meta.base.Types.EnumDefnThemeColorShade;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoColor extends StudioBase
{
  @Nullable
  public EnumDefnThemeColorShade shade;

  @Nullable
  public EnumDefnThemeColor value;
}
