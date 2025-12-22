// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnMapRenderingMode;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutLocmap extends StudioDtoLayoutGrid
{
  @Nullable
  public StudioDtoLayoutLocmapLineStroke lineStroke;

  @Nullable
  public StudioDtoLayoutLocmapPin liveLocationPin;

  @Nullable
  public MetaIdField locationFieldId;

  @Nullable
  public StudioDtoLayoutLocmapPin mapPin;

  @Nullable
  public EnumDefnMapRenderingMode renderingMode;
}
