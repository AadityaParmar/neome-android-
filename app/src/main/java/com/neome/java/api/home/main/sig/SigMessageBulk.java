// neome.ai API - do not change
//

package com.neome.java.api.home.main.sig;

import com.neome.java.api.meta.base.dto.EnvValidationError;
import com.neome.java.api.nucleus.base.sig.Sig;

import java.util.Map;

@SuppressWarnings("unused")
public class SigMessageBulk extends Sig
{
  public Map<Long, EnvValidationError> errorMap;

  public Map<Long, SigMessage> messageMap;
}
