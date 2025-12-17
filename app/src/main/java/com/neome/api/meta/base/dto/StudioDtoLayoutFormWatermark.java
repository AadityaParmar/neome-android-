// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnContentAlignment;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutFormWatermark extends StudioBase
{
  @Nullable
  public FieldDtoImage bgImage;

  @Nullable
  public EnumDefnContentAlignment bgImageHorizontalPosition;

  @Nullable
  public MetaIdVar bgImageVarId;

  @Nullable
  public EnumDefnContentAlignment bgImageVerticalPosition;

  @Nullable
  public MetaIdVar textOpacityVarId;

  @Nullable
  public StudioValueVarIdText textPatternVarId;

  @Nullable
  public MetaIdVar textPositionVarId;

  @Nullable
  public MetaIdVar textSizeVarId;
}
