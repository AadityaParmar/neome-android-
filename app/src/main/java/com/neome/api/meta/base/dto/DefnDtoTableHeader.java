// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnTextSize;
import com.neome.api.meta.base.Types.EnumDefnTextStyle;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdHeader;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoTableHeader
{
  @Nullable
  public DefnDtoColor bgColor;

  public String displayText;

  public MetaIdField[] fieldIdSet;

  public MetaIdHeader metaId;

  @Nullable
  public DefnDtoColor textColor;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public EnumDefnTextStyle[] textStyleSet;
}
