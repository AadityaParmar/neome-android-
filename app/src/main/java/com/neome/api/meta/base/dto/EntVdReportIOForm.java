// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdVdRegion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdReportIOForm extends VdBase
{
  @Nullable
  public Boolean expanded;

  @Nullable
  public MetaIdComposite[] expandedCompositeIdSet;

  public MetaIdForm formId;

  @Nullable
  public MetaIdVdRegion parentRegionId;

  @Nullable
  public Point point;
}
