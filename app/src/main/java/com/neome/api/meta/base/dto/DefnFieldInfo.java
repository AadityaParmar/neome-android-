// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnFieldInfo extends DefnFieldLabel
{
  @Nullable
  public EnumDefnThemeDividerKind bottomPadding;

  @Nullable
  public EnumDefnThemeDividerKind bottomPaddingVar;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public DefnDtoParagraph defaultVar;

  @Nullable
  public Boolean flexGrow;

  @Nullable
  public DefnDtoText labelPatternVar;

  @Nullable
  public EnumDefnThemeDividerKind leftPadding;

  @Nullable
  public EnumDefnThemeDividerKind leftPaddingVar;

  @Nullable
  public Long lineCount;

  @Nullable
  public MetaIdField lineCountFieldId;

  @Nullable
  public Long lineCountVar;

  @Nullable
  public EnumDefnThemeDividerKind rightPadding;

  @Nullable
  public EnumDefnThemeDividerKind rightPaddingVar;

  @Nullable
  public Boolean showBorder;

  @Nullable
  public Boolean showCloseButton;

  @Nullable
  public Boolean showLabel;

  @Nullable
  public EnumDefnThemeDividerKind topPadding;

  @Nullable
  public EnumDefnThemeDividerKind topPaddingVar;
}
