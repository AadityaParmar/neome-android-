// neome.ai API - do not change
//

package com.neome.api.nucleus.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DescApiTypeDto extends DescApiType
{
  public String dtoDir;

  @Nullable
  public Map<String, String> fieldMapJava;

  @Nullable
  public Map<String, String> fieldMapTypeScript;

  @Nullable
  public Map<String, String> importMap;

  @Nullable
  public String superClass;
}
