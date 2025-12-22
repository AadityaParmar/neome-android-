// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnDynamicOperator;
import com.neome.java.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoDynamicCondition
{
  public MetaIdField lhs;

  public EnumDefnDynamicOperator operator;

  @Nullable
  public FieldDtoArg rhs;
}
