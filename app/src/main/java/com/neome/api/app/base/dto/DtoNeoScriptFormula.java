// neome.ai API - do not change
//

package com.neome.api.app.base.dto;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdFormula;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoNeoScriptFormula extends DtoNeoScript
{
  @Nullable
  public MetaIdForm formId;

  @Nullable
  public MetaIdFormula formulaId;
}
