// neome.ai API - do not change
//

package com.neome.api.core.user.sig;

import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigBearerToken extends Sig
{
  public String bearerToken;

  @Nullable
  public SigCaller caller;

  public boolean updateRefreshToken;
}
