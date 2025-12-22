// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeImageRenderingMode;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutCardItem extends StudioBase
{
  @Nullable
  public StudioDtoLayoutCardItemLine fifthLine;

  @Nullable
  public StudioDtoLayoutCardItemLine firstLine;

  @Nullable
  public StudioDtoLayoutCardItemLine fourthLine;

  @Nullable
  public StudioDtoColor imageBackgroundColor;

  @Nullable
  public MetaIdVar imageCornerVarId;

  @Nullable
  public Long imageHeight;

  @Nullable
  public MetaIdVar imageHeightVarId;

  @Nullable
  public EnumDefnThemeImageRenderingMode imageRenderingMode;

  @Nullable
  public Long imageWidth;

  @Nullable
  public MetaIdVar imageWidthVarId;

  @Nullable
  public MetaIdField[] mediaFieldIdSet;

  @Nullable
  public MetaIdVar[] mediaVarIdSet;

  @Nullable
  public StudioDtoLayoutCardItemLine secondLine;

  @Nullable
  public StudioDtoLayoutCardItemLine thirdLine;
}
