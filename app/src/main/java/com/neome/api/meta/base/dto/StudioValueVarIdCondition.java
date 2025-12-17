// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioValueVarIdCondition extends StudioBase
{
  public MetaIdVar condVarId;

  @Nullable
  public Boolean negation;
}
