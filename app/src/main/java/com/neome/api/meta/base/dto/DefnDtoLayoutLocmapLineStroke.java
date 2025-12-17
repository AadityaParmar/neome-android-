// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnThemeStroke;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoLayoutLocmapLineStroke
{
  @Nullable
  public DefnDtoColor color;

  @Nullable
  public MetaIdField colorFieldId;

  @Nullable
  public DefnDtoColor colorVar;

  @Nullable
  public MetaIdField groupByFieldId;

  @Nullable
  public EnumDefnThemeStroke stroke;

  @Nullable
  public MetaIdField strokeFieldId;

  @Nullable
  public EnumDefnThemeStroke strokeVar;
}
