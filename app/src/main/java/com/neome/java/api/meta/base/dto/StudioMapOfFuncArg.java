// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdFuncArg;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfFuncArg extends StudioBase
{
  @Nullable
  public MetaIdFuncArg[] keys;

  public Map<MetaIdFuncArg, StudioDtoFuncArg> map;
}
