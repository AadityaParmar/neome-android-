// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base;

import com.neome.java.api.meta.base.sig.ISig;
import com.neome.java.api.nucleus.base.dto.EnvSignal;

public interface ISigAcceptor<S extends ISig>
{
  void execute(EnvSignal<S> envSig);
}
