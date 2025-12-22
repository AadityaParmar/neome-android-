// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdComposite;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVdRegion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdErdEntity extends VdBase
{
  @Nullable
  public Boolean expanded;

  @Nullable
  public MetaIdComposite[] expandedCompositeIdSet;

  @Nullable
  public MetaIdVdRegion parentRegionId;

  @Nullable
  public Point point;

  public MetaIdSpreadsheet spreadsheetId;
}
