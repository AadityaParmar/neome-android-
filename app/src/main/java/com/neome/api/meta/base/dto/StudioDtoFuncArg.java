// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnFuncArg;
import com.neome.api.meta.base.Types.MetaIdFuncArg;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoFuncArg extends StudioBase
{
  @Nullable
  public EnumDefnFuncArg funcArgKind;

  public MetaIdFuncArg metaId;

  public String name;

  @Nullable
  public Boolean required;
}
