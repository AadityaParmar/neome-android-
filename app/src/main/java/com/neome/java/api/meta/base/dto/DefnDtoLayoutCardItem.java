// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeImageCorner;
import com.neome.java.api.meta.base.Types.EnumDefnThemeImageRenderingMode;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoLayoutCardItem
{
  @Nullable
  public DefnDtoLayoutCardItemLine fifthLine;

  @Nullable
  public DefnDtoLayoutCardItemLine firstLine;

  @Nullable
  public DefnDtoLayoutCardItemLine fourthLine;

  @Nullable
  public DefnDtoColor imageBackgroundColor;

  @Nullable
  public EnumDefnThemeImageCorner imageCornerVar;

  @Nullable
  public Long imageHeight;

  @Nullable
  public Long imageHeightVar;

  @Nullable
  public EnumDefnThemeImageRenderingMode imageRenderingMode;

  @Nullable
  public Long imageWidth;

  @Nullable
  public Long imageWidthVar;

  @Nullable
  public MetaIdField[] mediaFieldIdSet;

  @Nullable
  public DefnDtoMedia[] mediaVarSet;

  @Nullable
  public DefnDtoLayoutCardItemLine secondLine;

  @Nullable
  public DefnDtoLayoutCardItemLine thirdLine;
}
