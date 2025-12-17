// neome.ai API - do not change
//

package com.neome.api.core.cluster.sig;

import com.neome.api.core.base.dto.DtoClusterItemMetric;
import com.neome.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigClusterItemData extends Sig
{
  public DtoClusterItemMetric[] metricList;

  public String[] nameColList;
}