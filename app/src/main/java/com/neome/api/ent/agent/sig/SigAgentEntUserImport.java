// neome.ai API - do not change
//

package com.neome.api.ent.agent.sig;

import com.neome.api.meta.base.Types.HandleKey;
import com.neome.api.meta.base.dto.EnvValidationError;
import com.neome.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigAgentEntUserImport extends Sig
{
  public Map<HandleKey, EnvValidationError> errorMap;
}
