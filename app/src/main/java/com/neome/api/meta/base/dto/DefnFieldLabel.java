// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPlacement;
import com.neome.api.meta.base.Types.EnumDefnTextSize;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldLabel extends DefnField
{
  @Nullable
  public DefnDtoColor bgColor;

  @Nullable
  public DefnDtoColor bgColorVar;

  @Nullable
  public Boolean bold;

  @Nullable
  public MetaIdField boldFieldId;

  @Nullable
  public Boolean boldVar;

  @Nullable
  public DefnDtoColor colorVar;

  @Nullable
  public Boolean italic;

  @Nullable
  public MetaIdField italicFieldId;

  @Nullable
  public Boolean italicVar;

  @Nullable
  public EnumDefnPlacement justifyText;

  @Nullable
  public EnumDefnPlacement justifyTextVar;

  @Nullable
  public Double opacity;

  @Nullable
  public MetaIdField opacityFieldId;

  @Nullable
  public Double opacityVar;

  @Nullable
  public Boolean strikeThrough;

  @Nullable
  public MetaIdField strikeThroughFieldId;

  @Nullable
  public Boolean strikeThroughVar;

  @Nullable
  public String textPattern;

  @Nullable
  public MetaIdField textPatternFieldId;

  @Nullable
  public DefnDtoText textPatternVar;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public MetaIdField textSizeFieldId;

  @Nullable
  public EnumDefnTextSize textSizeVar;

  @Nullable
  public Boolean underline;

  @Nullable
  public MetaIdField underlineFieldId;

  @Nullable
  public Boolean underlineVar;
}
