// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnTextSize;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoLayoutCardItemLineSegment
{
  @Nullable
  public DefnDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public DefnDtoColor colorVar;

  @Nullable
  public String line;

  @Nullable
  public MetaIdField[] lineFieldIdSet;

  @Nullable
  public DefnDtoText lineVar;

  @Nullable
  public Boolean showLabels;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public MetaIdField textSizeFieldId;

  @Nullable
  public EnumDefnTextSize textSizeVar;
}
