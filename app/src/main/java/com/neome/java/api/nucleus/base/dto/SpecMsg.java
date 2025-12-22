// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base.dto;

import com.neome.java.api.meta.base.Types.ServiceName;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class SpecMsg
{
  public String module;

  @Nullable
  public Map<String, String> paramMap;

  public ServiceName serviceName;
}
