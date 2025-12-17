// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnDynamicOperator;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoFieldDynamicCondition extends StudioBase
{
  public MetaIdField lhs;

  public EnumDefnDynamicOperator operator;

  @Nullable
  public StudioBuildArgBinder rhs;
}
