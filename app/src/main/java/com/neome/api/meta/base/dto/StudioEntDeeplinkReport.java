// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdReport;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntDeeplinkReport extends StudioEntDeeplinkWithHeader
{
  @Nullable
  public MetaIdLayoutForm outputFormContentLayoutId;

  @Nullable
  public MetaIdLayoutForm outputFormTemplateLayoutId;

  @Nullable
  public MetaIdReport reportId;
}
