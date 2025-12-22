// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdVisibilityRule;

@SuppressWarnings("unused")
public class DefnVisibilityRule
{
  public DefnVisibilityActionMap actionMapIfFalse;

  public DefnVisibilityActionMap actionMapIfTrue;

  public DefnVisibilityConditionMap conditionNode;

  public MetaIdVisibilityRule metaId;
}
