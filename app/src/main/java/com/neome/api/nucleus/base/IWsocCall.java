// neome.ai API - do not change
//

package com.neome.api.nucleus.base;

import com.neome.api.meta.base.msg.IMsg;
import com.neome.api.meta.base.sig.ISig;

public interface IWsocCall<S extends ISig>
{
  IWsocCall<S> get(IMsg msg, ISigAcceptor<S> sigAcceptor);

  IWsocCall<S> post(IMsg msg, ISigAcceptor<S> sigAcceptor);

  IWsocCall<S> patch(IMsg msg, ISigAcceptor<S> sigAcceptor);

  IWsocCall<S> put(IMsg msg, ISigAcceptor<S> sigAcceptor);

  IWsocCall<S> delete(IMsg msg, ISigAcceptor<S> sigAcceptor);
}
