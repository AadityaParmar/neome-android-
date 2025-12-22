// neome.ai API - do not change
//

package com.neome.java.api.nucleus.api.sig;

import com.neome.java.api.nucleus.base.dto.DescApiModule;
import com.neome.java.api.nucleus.base.dto.DescApiPushSigs;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigApiLib extends Sig
{
  public Map<String, DescApiModule> api;

  public DescApiPushSigs pushSigs;
}
