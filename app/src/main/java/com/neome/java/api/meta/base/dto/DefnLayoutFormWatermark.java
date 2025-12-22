// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnContentAlignment;
import com.neome.java.api.meta.base.Types.EnumDefnPlacement;
import com.neome.java.api.meta.base.Types.EnumDefnTextSize;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutFormWatermark
{
  @Nullable
  public FieldDtoImage bgImage;

  @Nullable
  public EnumDefnContentAlignment bgImageHorizontalPosition;

  @Nullable
  public FieldDtoImage bgImageVar;

  @Nullable
  public EnumDefnContentAlignment bgImageVerticalPosition;

  @Nullable
  public Double textOpacityVar;

  @Nullable
  public DefnDtoText textPatternVar;

  @Nullable
  public EnumDefnPlacement textPositionVar;

  @Nullable
  public EnumDefnTextSize textSizeVar;
}
