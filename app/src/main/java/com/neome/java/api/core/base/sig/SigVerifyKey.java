// neome.ai API - do not change
//

package com.neome.java.api.core.base.sig;

import com.neome.java.api.meta.base.AnyKey;
import com.neome.java.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigVerifyKey extends Sig
{
  public long expiryMins;

  public AnyKey verifyKey;
}
