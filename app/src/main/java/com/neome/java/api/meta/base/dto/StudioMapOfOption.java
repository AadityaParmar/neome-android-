// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfOption extends StudioBase
{
  @Nullable
  public Boolean addTextColor;

  public String[] keys;

  public Map<String, StudioDtoOption> map;
}
