// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.meta.base.Types.EnumDefnRenderingKind;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.dto.DefnForm;
import com.neome.api.meta.base.dto.FormValue;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DeeplinkDataPayloadEntReportShare extends DeeplinkDataPayloadEnt
{
  public DefnForm defnForm;

  public FormValue formValue;

  @Nullable
  public MetaIdLayoutForm outputFormContentLayoutId;

  @Nullable
  public MetaIdLayoutForm outputFormTemplateLayoutId;

  @Nullable
  public Long paperHeight;

  @Nullable
  public EnumDefnRenderingKind paperSize;

  @Nullable
  public Long paperWidth;

  @Nullable
  public String reportLabel;

  public String reportName;
}
