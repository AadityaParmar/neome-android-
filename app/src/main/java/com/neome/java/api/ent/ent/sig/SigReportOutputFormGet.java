// neome.ai API - do not change
//

package com.neome.java.api.ent.ent.sig;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.dto.FormValue;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigReportOutputFormGet extends Sig
{
  public MetaIdForm formId;

  public FormValue formValue;

  @Nullable
  public MetaIdLayoutForm outputFormContentLayoutId;

  @Nullable
  public MetaIdLayoutForm outputFormTemplateLayoutId;

  @Nullable
  public String reportLabel;

  public String reportName;
}
