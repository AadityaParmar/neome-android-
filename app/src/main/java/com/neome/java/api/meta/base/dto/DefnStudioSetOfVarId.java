// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumStudioVarKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnStudioSetOfVarId extends DefnFieldEditable
{
  @Nullable
  public EnumStudioVarKind varKind;

  @Nullable
  public EnumStudioVarKind[] varKindSet;
}
