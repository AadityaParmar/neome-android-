// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVdRegion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdErdRef extends StudioBase
{
  @Nullable
  public Boolean diamondExpanded;

  @Nullable
  public MetaIdVdRegion diamondParentRegionId;

  @Nullable
  public Point diamondPoint;

  @Nullable
  public Boolean expanded;

  public MetaIdField fieldId;

  @Nullable
  public String fromNodeHandleId;

  @Nullable
  public MetaIdSpreadsheet fromNodeId;

  @Nullable
  public MetaIdVdRegion parentRegionId;

  @Nullable
  public Point point;

  @Nullable
  public MetaIdSpreadsheet toNodeId;
}
