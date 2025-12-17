// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindBranchIfElse;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdBranchIfElse extends EntVdAutoStep
{
  @Nullable
  public StudioMapOfCondition condition;

  @Nullable
  public MetaIdVar conditionVarId;

  @Nullable
  public EnumDefnKindBranchIfElse option;
}
