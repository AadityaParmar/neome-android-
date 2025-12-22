// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.home.base.dto.DtoNewChatCandidate;
import com.neome.java.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigChatCandidateMap extends Sig
{
  public Map<AnyPrefixKey, DtoNewChatCandidate[]> candidateMap;
}
