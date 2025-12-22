// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn;
import com.neome.java.api.meta.base.Types.EnumDefnTextSize;
import com.neome.java.api.meta.base.Types.EnumDefnTextStyle;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdTableStyle;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoTableStyle
{
  @Nullable
  public DefnDtoColor bgColor;

  @Nullable
  public DefnStudioDtoCondition conditionVar;

  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public EnumDefnDriveSheetFieldLayoutOn fieldLayoutOn;

  @Nullable
  public MetaIdTableStyle metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public DefnDtoColor textColor;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public EnumDefnTextStyle[] textStyleSet;
}
