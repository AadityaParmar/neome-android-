// neome.ai API - do not change
//

package com.neome.api.app.ai.sig;

import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigAiNeoScriptGen extends Sig
{
  @Nullable
  public String error;

  @Nullable
  public String[] neoScripts;

  @Nullable
  public String userMessage;
}
