// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.home.drawer.sig.SigUserAvatar;
import com.neome.java.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigUserMessageCandidateList extends Sig
{
  public Map<AnyPrefixKey, SigUserAvatar[]> candidateMap;
}
