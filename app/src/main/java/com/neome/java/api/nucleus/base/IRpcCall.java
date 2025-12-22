// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base;

import com.neome.java.api.meta.base.msg.IMsg;
import com.neome.java.api.meta.base.sig.ISig;

public interface IRpcCall<S extends ISig>
{
  IRpcCall<S> sendBearerToken();

  IRpcCall<S> sendRefreshToken();

  IRpcCall<S> get(IMsg msg, ISigAcceptor<S> sigAcceptor);

  IRpcCall<S> post(IMsg msg, ISigAcceptor<S> sigAcceptor);

  IRpcCall<S> patch(IMsg msg, ISigAcceptor<S> sigAcceptor);

  IRpcCall<S> put(IMsg msg, ISigAcceptor<S> sigAcceptor);

  IRpcCall<S> delete(IMsg msg, ISigAcceptor<S> sigAcceptor);
}
