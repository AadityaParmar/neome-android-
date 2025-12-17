// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnDriveSheetFieldLayoutOn;
import com.neome.api.meta.base.Types.EnumDefnTextSize;
import com.neome.api.meta.base.Types.EnumDefnTextStyle;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdTableStyle;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoTableStyle extends StudioBase
{
  @Nullable
  public StudioDtoColor bgColor;

  @Nullable
  public StudioValueVarIdCondition conditionVarId;

  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public EnumDefnDriveSheetFieldLayoutOn fieldLayoutOn;

  @Nullable
  public MetaIdTableStyle metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public StudioDtoColor textColor;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public EnumDefnTextStyle[] textStyleSet;
}
