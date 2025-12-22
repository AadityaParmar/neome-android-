// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeDividerKind;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioFieldInfo extends StudioFieldLabel
{
  @Nullable
  public EnumDefnThemeDividerKind bottomPadding;

  @Nullable
  public MetaIdVar bottomPaddingVarId;

  @Nullable
  public MetaIdField defaultFieldId;

  @Nullable
  public String defaultValue;

  @Nullable
  public StudioValueVarIdParagraph defaultVarId;

  @Nullable
  public Boolean flexGrow;

  @Nullable
  public StudioValueVarIdText labelPatternVarId;

  @Nullable
  public EnumDefnThemeDividerKind leftPadding;

  @Nullable
  public MetaIdVar leftPaddingVarId;

  @Nullable
  public Long lineCount;

  @Nullable
  public MetaIdField lineCountFieldId;

  @Nullable
  public MetaIdVar lineCountVarId;

  @Nullable
  public EnumDefnThemeDividerKind rightPadding;

  @Nullable
  public MetaIdVar rightPaddingVarId;

  @Nullable
  public Boolean showBorder;

  @Nullable
  public Boolean showCloseButton;

  @Nullable
  public Boolean showLabel;

  @Nullable
  public EnumDefnThemeDividerKind topPadding;

  @Nullable
  public MetaIdVar topPaddingVarId;
}
