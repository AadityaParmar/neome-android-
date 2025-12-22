// neome.ai API - do not change
//

package com.neome.java.api.app.ai.sig;

import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigAiNeoQLGet extends Sig
{
  public boolean error;

  @Nullable
  public String errorReason;

  @Nullable
  public String response;
}
