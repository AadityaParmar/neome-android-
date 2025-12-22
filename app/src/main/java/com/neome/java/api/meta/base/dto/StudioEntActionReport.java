// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdReport;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntActionReport extends StudioEntAction
{
  @Nullable
  public MetaIdLayoutForm outputFormContentLayoutId;

  @Nullable
  public MetaIdLayoutForm outputFormTemplateLayoutId;

  @Nullable
  public MetaIdReport reportId;

  @Nullable
  public Boolean sendMessageToInbox;
}
