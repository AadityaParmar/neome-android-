// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdSwimlane;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoSwimlane;

@SuppressWarnings("unused")
public class StudioMapOfSwimlane extends StudioBase
{
  @Nullable
  public MetaIdSwimlane[] keys;

  public Map<MetaIdSwimlane, StudioDtoSwimlane> map;
}
