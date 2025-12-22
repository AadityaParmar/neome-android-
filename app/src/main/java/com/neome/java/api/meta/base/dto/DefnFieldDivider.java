// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeColor;
import com.neome.java.api.meta.base.Types.EnumDefnThemeDirection;
import com.neome.java.api.meta.base.Types.EnumDefnThemeDividerKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldDivider extends DefnField
{
  @Nullable
  public DefnDtoColor color;

  @Nullable
  public EnumDefnThemeColor colorVar;

  @Nullable
  public EnumDefnThemeDividerKind dividerKind;

  @Nullable
  public EnumDefnThemeDividerKind dividerKindVar;

  @Nullable
  public EnumDefnThemeDirection sectionDirection;
}
