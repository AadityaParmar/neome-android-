// neome.ai API - do not change
//

package com.neome.api.core.base.sig;

import com.neome.api.meta.base.AnyKey;
import com.neome.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigVerifyKey extends Sig
{
  public long expiryMins;

  public AnyKey verifyKey;
}