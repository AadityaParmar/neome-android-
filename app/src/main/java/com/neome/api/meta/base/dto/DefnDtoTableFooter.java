// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnPlacement;
import com.neome.api.meta.base.Types.EnumDefnTextSize;
import com.neome.api.meta.base.Types.EnumDefnTextStyle;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdFooter;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoTableFooter
{
  @Nullable
  public EnumDefnPlacement alignment;

  @Nullable
  public DefnDtoColor bgColor;

  public MetaIdField displayFieldId;

  public MetaIdField[] fieldIdSet;

  public MetaIdFooter metaId;

  @Nullable
  public Boolean showLabel;

  @Nullable
  public DefnDtoColor textColor;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public EnumDefnTextStyle[] textStyleSet;
}
