// neome.ai API - do not change
//

package com.neome.api.nucleus.base;

import com.neome.api.meta.base.sig.ISig;
import com.neome.api.nucleus.base.dto.EnvSignal;

public interface ISigAcceptor<S extends ISig>
{
  void execute(EnvSignal<S> envSig);
}