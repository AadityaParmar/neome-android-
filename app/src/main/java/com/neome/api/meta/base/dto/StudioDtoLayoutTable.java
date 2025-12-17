// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode;
import com.neome.api.meta.base.Types.EnumDefnSortOrder;
import com.neome.api.meta.base.Types.EnumDefnTableLayoutTheme;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioDtoLayoutTable extends StudioDtoLayoutGrid
{
  @Nullable
  public Boolean allowCustomFilters;

  @Nullable
  public String[] columnAlignmentArray;

  @Nullable
  public String[] columnSizeSet;

  @Nullable
  public StudioMapOfTableFooter footer;

  @Nullable
  public MetaIdField[] freezeFieldIdSet;

  @Nullable
  public StudioMapOfTableHeader header;

  @Nullable
  public Boolean hideHeaders;

  @Nullable
  public Boolean hideRowSeparator;

  @Nullable
  public String indexColumnName;

  @Nullable
  public Map<MetaIdComposite, MetaIdLayoutGrid> masterDetailGridLayoutMap;

  @Nullable
  public Boolean pagination;

  @Nullable
  public EnumDefnGridRenderingMode renderingMode;

  @Nullable
  public Long rowsPerPage;

  @Nullable
  public Boolean showCommentCount;

  @Nullable
  public MetaIdComp[] showCompIdSet;

  @Nullable
  public Boolean showSearchBar;

  @Nullable
  public MetaIdField[] sortByFieldIdSet;

  @Nullable
  public EnumDefnSortOrder sortOrder;

  @Nullable
  public Map<MetaIdGrid, MetaIdLayoutGrid> sparklineLayoutMap;

  @Nullable
  public StudioMapOfTableStyle styleMap;

  @Nullable
  public EnumDefnTableLayoutTheme theme;
}
