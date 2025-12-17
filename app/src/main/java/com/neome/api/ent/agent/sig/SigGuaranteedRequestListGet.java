// neome.ai API - do not change
//

package com.neome.api.ent.agent.sig;

import com.neome.api.ent.base.dto.GuaranteedRequest;
import com.neome.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigGuaranteedRequestListGet extends Sig
{
  public long bottomOffset;

  public GuaranteedRequest[] list;

  public long pageBottomOffset;
}