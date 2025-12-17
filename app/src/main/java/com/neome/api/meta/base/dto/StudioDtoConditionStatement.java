// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnConditionOperator;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoConditionStatement extends StudioBase
{
  @Nullable
  public StudioBuildArgBinder lhs;

  @Nullable
  public EnumDefnConditionOperator operator;

  @Nullable
  public StudioBuildArgBinder rhs;
}
