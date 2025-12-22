// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnVisibilityOperator;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnVisibilityCondition
{
  public MetaIdField lhs;

  public EnumDefnVisibilityOperator operator;

  @Nullable
  public FieldDtoArg rhs;
}
