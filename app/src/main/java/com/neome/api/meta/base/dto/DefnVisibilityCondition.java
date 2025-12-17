// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnVisibilityOperator;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnVisibilityCondition
{
  public MetaIdField lhs;

  public EnumDefnVisibilityOperator operator;

  @Nullable
  public FieldDtoArg rhs;
}
