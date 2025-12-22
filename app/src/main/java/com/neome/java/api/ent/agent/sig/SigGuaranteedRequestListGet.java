// neome.ai API - do not change
//

package com.neome.java.api.ent.agent.sig;

import com.neome.java.api.ent.base.dto.GuaranteedRequest;
import com.neome.java.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigGuaranteedRequestListGet extends Sig
{
  public long bottomOffset;

  public GuaranteedRequest[] list;

  public long pageBottomOffset;
}
