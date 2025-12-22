// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnGridRenderingMode;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutCard extends StudioDtoLayoutGrid
{
  @Nullable
  public StudioDtoLayoutCardFilter filter;

  @Nullable
  public MetaIdField groupByFieldId;

  @Nullable
  public Boolean hideBorders;

  @Nullable
  public StudioDtoLayoutCardItem item;

  @Nullable
  public Long numOfColumns;

  @Nullable
  public EnumDefnGridRenderingMode renderingMode;

  @Nullable
  public Boolean showSearchBar;
}
