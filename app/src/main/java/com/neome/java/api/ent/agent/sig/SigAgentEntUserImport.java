// neome.ai API - do not change
//

package com.neome.java.api.ent.agent.sig;

import com.neome.java.api.meta.base.Types.HandleKey;
import com.neome.java.api.meta.base.dto.EnvValidationError;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigAgentEntUserImport extends Sig
{
  public Map<HandleKey, EnvValidationError> errorMap;
}
