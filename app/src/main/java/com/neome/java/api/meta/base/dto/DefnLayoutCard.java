// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnGridRenderingMode;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutCard extends DefnLayoutGrid
{
  @Nullable
  public DefnDtoLayoutCardFilter filter;

  @Nullable
  public MetaIdField groupByFieldId;

  @Nullable
  public Boolean hideBorders;

  public DefnDtoLayoutCardItem item;

  @Nullable
  public Long numOfColumns;

  @Nullable
  public EnumDefnGridRenderingMode renderingMode;

  @Nullable
  public Boolean showSearchBar;
}
