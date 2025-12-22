// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdReport;

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
