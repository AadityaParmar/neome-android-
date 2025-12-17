// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnKindAction;
import com.neome.api.meta.base.Types.MetaIdAction;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioPickActionId extends DefnFieldEditable
{
  @Nullable
  public MetaIdAction[] excludeActionIdSet;

  @Nullable
  public EnumDefnKindAction[] filterActionKindSet;

  @Nullable
  public MetaIdAction[] includeActionIdSet;
}
