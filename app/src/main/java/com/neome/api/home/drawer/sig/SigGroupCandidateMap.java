// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigGroupCandidateMap extends Sig
{
  public Map<AnyPrefixKey, SigUserAvatar[]> candidateMap;
}
