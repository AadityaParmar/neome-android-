// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdGrid;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoMapping
{
  @Nullable
  public StudioDtoMappingFieldMap fieldMappingMap;

  @Nullable
  public MetaIdGrid fromGridId;

  @Nullable
  public StudioDtoMappingGridMap gridMappingMap;

  @Nullable
  public MetaIdGrid toGridId;
}
