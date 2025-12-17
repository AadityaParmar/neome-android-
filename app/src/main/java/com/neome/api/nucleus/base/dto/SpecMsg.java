// neome.ai API - do not change
//

package com.neome.api.nucleus.base.dto;

import com.neome.api.meta.base.Types.ServiceName;

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
