// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnConditionOperator;
import com.neome.java.api.meta.base.Types.MetaIdCondition;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoConditionStatement
{
  public FieldDtoArg lhs;

  public MetaIdCondition metaId;

  @Nullable
  public EnumDefnConditionOperator operator;

  @Nullable
  public FieldDtoArg rhs;
}
