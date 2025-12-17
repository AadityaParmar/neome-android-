// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnThemeButtonSize;
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant;
import com.neome.api.meta.base.Types.EnumDefnThemeFieldMargin;
import com.neome.api.meta.base.Types.EnumDefnThemeFieldSize;
import com.neome.api.meta.base.Types.EnumDefnThemeFieldVariant;
import com.neome.api.meta.base.Types.EnumDefnThemeFormVariant;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoFormTheme
{
  @Nullable
  public EnumDefnThemeButtonSize buttonSize;

  @Nullable
  public EnumDefnThemeButtonVariant buttonVariant;

  @Nullable
  public Long colSpacing;

  @Nullable
  public EnumDefnThemeFieldMargin fieldMargin;

  @Nullable
  public EnumDefnThemeFieldSize fieldSize;

  @Nullable
  public EnumDefnThemeFieldVariant fieldVariant;

  @Nullable
  public EnumDefnThemeFormVariant formVariant;

  @Nullable
  public Long rowSpacing;
}
