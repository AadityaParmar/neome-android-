// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.home.drawer.sig.SigGroupAvatar;
import com.neome.java.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigGroupMessageCandidateList extends Sig
{
  public Map<AnyPrefixKey, SigGroupAvatar[]> candidateMap;
}
