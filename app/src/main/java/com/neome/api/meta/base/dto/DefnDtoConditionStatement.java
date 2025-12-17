// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnConditionOperator;
import com.neome.api.meta.base.Types.MetaIdCondition;

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
