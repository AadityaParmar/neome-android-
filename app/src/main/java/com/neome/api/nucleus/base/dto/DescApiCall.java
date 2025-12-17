// neome.ai API - do not change
//

package com.neome.api.nucleus.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DescApiCall
{
  @Nullable
  public Map<String, SpecApi> call;

  @Nullable
  public Map<String, String> importMap;

  public String pathSeg;
}
