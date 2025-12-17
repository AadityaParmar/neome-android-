// neome.ai API - do not change
//

package com.neome.api.app.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoNeoScriptLayout extends DtoNeoScript
{
  @Nullable
  public MetaIdForm formId;

  @Nullable
  public MetaIdLayoutForm formLayoutId;
}
