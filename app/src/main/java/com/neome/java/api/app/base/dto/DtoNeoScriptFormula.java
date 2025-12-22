// neome.ai API - do not change
//

package com.neome.java.api.app.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdFormula;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoNeoScriptFormula extends DtoNeoScript
{
  @Nullable
  public MetaIdForm formId;

  @Nullable
  public MetaIdFormula formulaId;
}
