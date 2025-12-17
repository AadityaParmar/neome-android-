// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.Types.EnumDefnFuncArg;
import com.neome.api.meta.base.dto.StudioMapOfFuncArg;
import com.neome.api.meta.base.dto.StudioValueCodeJavascript;

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
