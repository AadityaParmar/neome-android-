// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoOption;

@SuppressWarnings("unused")
public class StudioMapOfOption extends StudioBase
{
  @Nullable
  public Boolean addTextColor;

  public String[] keys;

  public Map<String, StudioDtoOption> map;
}
