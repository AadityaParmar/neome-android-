// neome.ai API - do not change
//

package com.neome.api.home.main.sig;

import com.neome.api.home.drawer.sig.SigUserAvatar;
import com.neome.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigUserMessageCandidateList extends Sig
{
  public Map<AnyPrefixKey, SigUserAvatar[]> candidateMap;
}
