// neome.ai API - do not change
//

package com.neome.java.api.core.user.sig;

import com.neome.java.api.nucleus.base.sig.Sig;

@SuppressWarnings("unused")
public class SigAppVersion extends Sig
{
  public long currVersionCode;

  public boolean hasForceUpdate;

  public boolean hasUpdate;

  public long mmkvVersion;

  public long sqlVersion;
}
