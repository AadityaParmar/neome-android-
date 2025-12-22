// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdSwimlane;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfSwimlane extends StudioBase
{
  @Nullable
  public MetaIdSwimlane[] keys;

  public Map<MetaIdSwimlane, StudioDtoSwimlane> map;
}
