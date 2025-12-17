// neome.ai API - do not change
//

package com.neome.api.app.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdVisibilityRule;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoNeoScriptVisibilityRule extends DtoNeoScript
{
  @Nullable
  public MetaIdForm formId;

  @Nullable
  public MetaIdVisibilityRule visibilityRuleId;
}
