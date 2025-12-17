// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnMapRenderingMode;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutGridLocmap extends DefnLayoutGrid
{
  @Nullable
  public DefnDtoLayoutLocmapLineStroke lineStroke;

  @Nullable
  public DefnDtoLayoutLocmapPin liveLocationPin;

  @Nullable
  public MetaIdField locationFieldId;

  @Nullable
  public DefnDtoLayoutLocmapPin mapPin;

  @Nullable
  public EnumDefnMapRenderingMode renderingMode;
}
