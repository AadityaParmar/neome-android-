// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnLayoutCardFilterKind;
import com.neome.java.api.meta.base.Types.EnumDefnSortOrder;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoLayoutCardFilter
{
  @Nullable
  public MetaIdField[] advanceFilterFieldIdSet;

  @Nullable
  public MetaIdField[] categoryFieldIdSet;

  @Nullable
  public EnumDefnLayoutCardFilterKind kind;

  @Nullable
  public Boolean showSearchBar;

  @Nullable
  public MetaIdField[] sortByFieldIdSet;

  @Nullable
  public EnumDefnSortOrder sortOrder;
}
