// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.MetaIdVisibilityRule;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioVisibilityRule extends StudioBase
{
  public StudioVisibilityActionMap actionMapIfFalse;

  public StudioVisibilityActionMap actionMapIfTrue;

  @Nullable
  public String description;

  public MetaIdVisibilityRule metaId;

  public Symbol name;

  @Nullable
  public StudioMapOfVisibilityCondition visibilityCondMap;
}
