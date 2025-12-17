// neome.ai API - do not change
//

package com.neome.api.nucleus.base;

import com.neome.api.meta.base.sig.ISig;

public interface ISigPushAcceptor<S extends ISig>
{
  void execute(S sig);
}