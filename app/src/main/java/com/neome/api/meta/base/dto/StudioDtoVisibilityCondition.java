// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnVisibilityOperator;
import com.neome.api.meta.base.Types.MetaIdField;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoVisibilityCondition extends StudioBase
{
  public MetaIdField lhs;

  public EnumDefnVisibilityOperator operator;

  @Nullable
  public StudioBuildArgBinder rhs;
}
