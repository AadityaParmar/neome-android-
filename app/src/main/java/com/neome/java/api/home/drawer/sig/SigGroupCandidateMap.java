// neome.ai API - do not change
//

package com.neome.java.api.home.drawer.sig;

import com.neome.java.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigGroupCandidateMap extends Sig
{
  public Map<AnyPrefixKey, SigUserAvatar[]> candidateMap;
}
