// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdSwimlane;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DefnStudioMapOfSwimlane extends DefnField
{
  @Nullable
  public MetaIdSwimlane[] keys;

  public Map<MetaIdSwimlane, DefnDtoSwimlane> map;
}
