// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPlacement;
import com.neome.api.meta.base.Types.EnumDefnTextSize;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldLabel extends StudioField
{
  @Nullable
  public StudioDtoColor bgColor;

  @Nullable
  public MetaIdVar bgColorVarId;

  @Nullable
  public Boolean bold;

  @Nullable
  public MetaIdField boldFieldId;

  @Nullable
  public MetaIdVar boldVarId;

  @Nullable
  public MetaIdVar colorVarId;

  @Nullable
  public Boolean italic;

  @Nullable
  public MetaIdField italicFieldId;

  @Nullable
  public MetaIdVar italicVarId;

  @Nullable
  public EnumDefnPlacement justifyText;

  @Nullable
  public MetaIdVar justifyTextVarId;

  @Nullable
  public Double opacity;

  @Nullable
  public MetaIdField opacityFieldId;

  @Nullable
  public MetaIdVar opacityVarId;

  @Nullable
  public Boolean strikeThrough;

  @Nullable
  public MetaIdField strikeThroughFieldId;

  @Nullable
  public MetaIdVar strikeThroughVarId;

  @Nullable
  public String textPattern;

  @Nullable
  public MetaIdField textPatternFieldId;

  @Nullable
  public StudioValueVarIdText textPatternVarId;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public MetaIdField textSizeFieldId;

  @Nullable
  public MetaIdVar textSizeVarId;

  @Nullable
  public Boolean underline;

  @Nullable
  public MetaIdField underlineFieldId;

  @Nullable
  public MetaIdVar underlineVarId;
}
