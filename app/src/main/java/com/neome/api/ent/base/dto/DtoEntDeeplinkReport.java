// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdReport;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoEntDeeplinkReport extends DtoEntDeeplink
{
  @Nullable
  public MetaIdLayoutForm outputFormContentLayoutId;

  @Nullable
  public MetaIdLayoutForm outputFormTemplateLayoutId;

  @Nullable
  public MetaIdReport reportId;
}
