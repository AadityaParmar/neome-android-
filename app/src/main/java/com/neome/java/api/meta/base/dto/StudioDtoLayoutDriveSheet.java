// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnConditionOperator;
import com.neome.java.api.meta.base.Types.EnumDefnContentAlignment;
import com.neome.java.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn;
import com.neome.java.api.meta.base.Types.EnumDefnDriveSheetLayoutFor;
import com.neome.java.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.java.api.meta.base.Types.EnumDefnTextStyle;
import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdLayoutDriveSheet;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutDriveSheet extends StudioBase
{
  @Nullable
  public EnumDefnContentAlignment alignment;

  @Nullable
  public DefnDtoColor bgColor;

  @Nullable
  public EnumDefnShowBorderKind[] borderSet;

  @Nullable
  public MetaIdComposite compositeId;

  @Nullable
  public EnumDefnConditionOperator conditionOperator;

  @Nullable
  public StudioBuildArgBinder conditionValue;

  @Nullable
  public MetaIdField fieldId;

  @Nullable
  public EnumDefnDriveSheetFieldLayoutOn fieldLayoutOn;

  @Nullable
  public Long fontSize;

  public EnumDefnDriveSheetLayoutFor layoutFor;

  public MetaIdLayoutDriveSheet metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public DefnDtoColor textColor;

  @Nullable
  public EnumDefnTextStyle[] textStyleSet;

  @Nullable
  public Long width;
}
