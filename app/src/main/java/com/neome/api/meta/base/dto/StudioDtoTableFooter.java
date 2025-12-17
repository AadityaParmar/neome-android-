// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnPlacement;
import com.neome.api.meta.base.Types.EnumDefnTextSize;
import com.neome.api.meta.base.Types.EnumDefnTextStyle;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdFooter;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoTableFooter extends StudioBase
{
  @Nullable
  public EnumDefnPlacement alignment;

  @Nullable
  public StudioDtoColor bgColor;

  @Nullable
  public MetaIdField displayFieldId;

  public MetaIdField[] fieldIdSet;

  public MetaIdFooter metaId;

  @Nullable
  public Symbol name;

  @Nullable
  public Boolean showLabel;

  @Nullable
  public StudioDtoColor textColor;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public EnumDefnTextStyle[] textStyleSet;
}
