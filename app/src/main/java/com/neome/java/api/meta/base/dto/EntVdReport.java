// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdReport;
import com.neome.java.api.meta.base.Types.MetaIdVdRegion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdReport extends StudioBase
{
  @Nullable
  public Boolean expanded;

  @Nullable
  public MetaIdVdRegion parentRegionId;

  @Nullable
  public Point point;

  public MetaIdReport reportId;
}
