// neome.ai API - do not change
//

package com.neome.java.api.core.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DtoClusterItemMetric
{
  public double avgTime;

  public long emptyCount;

  public long failureCount;

  public long maxTime;

  public double medianTime;

  public long minTime;

  public String[] name;

  public double p80Time;

  public double p90Time;

  public double p95Time;

  public double p999Time;

  public double p99Time;

  @Nullable
  public Long sla;

  public long successCount;

  public long totalCount;
}
