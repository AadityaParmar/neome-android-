// neome.ai API - do not change
//

package com.neome.api.home.main.sig;

import com.neome.api.home.base.dto.DtoNewChatCandidate;
import com.neome.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigChatCandidateMap extends Sig
{
  public Map<AnyPrefixKey, DtoNewChatCandidate[]> candidateMap;
}
