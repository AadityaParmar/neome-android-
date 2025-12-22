// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnSortOrder;
import com.neome.java.api.meta.base.Types.EnumDefnTextSize;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutKanban extends DefnLayoutGrid
{
  @Nullable
  public MetaIdField kanbanFieldId;

  @Nullable
  public Boolean showCommentCount;

  @Nullable
  public MetaIdField[] showFieldIdSet;

  @Nullable
  public Boolean showFooter;

  @Nullable
  public Boolean showSectionName;

  @Nullable
  public MetaIdField[] sortByFieldIdSet;

  @Nullable
  public EnumDefnSortOrder sortOrder;

  @Nullable
  public DefnStudioMapOfSwimlane swimlaneMap;

  @Nullable
  public EnumDefnTextSize textSize;
}
