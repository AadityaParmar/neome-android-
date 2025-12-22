// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base;

import com.neome.java.api.meta.base.sig.ISig;

public interface ISigPushAcceptor<S extends ISig>
{
  void execute(S sig);
}
