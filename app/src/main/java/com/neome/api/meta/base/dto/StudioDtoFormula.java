// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdFormula;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoFormula extends StudioBase
{
  public MetaIdField assignToFieldId;

  @Nullable
  public StudioValueVarIdCondition conditionVarId;

  @Nullable
  public StudioValueCodeJavascript formula;

  public MetaIdFormula metaId;

  @Nullable
  public Symbol name;
}
