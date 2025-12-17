// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVisibilityRule;

@SuppressWarnings("unused")
public class DefnVisibilityRule
{
  public DefnVisibilityActionMap actionMapIfFalse;

  public DefnVisibilityActionMap actionMapIfTrue;

  public DefnVisibilityConditionMap conditionNode;

  public MetaIdVisibilityRule metaId;
}
