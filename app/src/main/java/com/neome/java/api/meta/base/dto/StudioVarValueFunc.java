// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnFuncArg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioVarValueFunc
{
  @Nullable
  public StudioMapOfFuncArg inputFuncArgMap;

  @Nullable
  public StudioValueCodeJavascript javascript;

  @Nullable
  public EnumDefnFuncArg outputKind;
}
