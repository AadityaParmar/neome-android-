// neome.ai API - do not change
//

package com.neome.api.nucleus.base.dto;

import com.neome.api.meta.base.Types.ServiceName;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class DescApiService
{
  public Map<String, DescApiTypeBasic> basic;

  public Map<String, String> consts;

  public Map<String, DescApiTypeDto> dto;

  public Map<String, DescApiTypeEnum> enums;

  public Map<String, DescApiTypeDto> msg;

  public DescApiCall rpc;

  @Nullable
  public Set<ServiceName> serviceNames;

  public Map<String, DescApiTypeSet> sets;

  public Map<String, DescApiTypeDto> sig;

  public Map<String, String> symbols;

  public Map<String, DescApiTypeSysId> sysId;

  public Map<String, String> sysIdPrefix;

  public DescApiCall wsoc;
}
