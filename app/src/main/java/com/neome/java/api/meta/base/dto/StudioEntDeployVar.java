// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumStudioVarKind;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntDeployVar extends StudioBase
{
  public EnumStudioVarKind kind;

  public MetaIdVar metaId;

  @Nullable
  public Object varValue;
}
