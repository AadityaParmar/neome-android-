// neome.ai API - do not change
//

package com.neome.java.api;

import com.neome.java.api.core.session.sig.SigSignOut;
import com.neome.java.api.core.session.sig.SigTopic;
import com.neome.java.api.core.session.sig.SigTopicAnalyticEvent;
import com.neome.java.api.ent.agent.sig.SigTopicPluginApiRequest;
import com.neome.java.api.ent.session.sig.SigTopicSpreadsheetRef;
import com.neome.java.api.home.session.sig.SigTopicGroupTyping;
import com.neome.java.api.home.session.sig.SigTopicMessageNew;
import com.neome.java.api.home.session.sig.SigTopicMessageProps;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.meta.base.sig.ISig;
import com.neome.java.api.nucleus.base.ISigPushAcceptor;

@SuppressWarnings("unused")
public class PushSigs
{
  private ISigPushAcceptor<SigSignOut> cbSessionSigSignOut;
  private ISigPushAcceptor<SigTopic> cbSessionSigTopic;
  private ISigPushAcceptor<SigTopicAnalyticEvent> cbSessionSigTopicAnalyticEvent;
  private ISigPushAcceptor<SigTopicGroupTyping> cbSessionSigTopicGroupTyping;
  private ISigPushAcceptor<SigTopicMessageNew> cbSessionSigTopicMessageNew;
  private ISigPushAcceptor<SigTopicMessageProps> cbSessionSigTopicMessageProps;
  private ISigPushAcceptor<SigTopicPluginApiRequest> cbAgentSigTopicPluginApiRequest;
  private ISigPushAcceptor<SigTopicSpreadsheetRef> cbSessionSigTopicSpreadsheetRef;

  public void setCbSessionSigSignOut(ISigPushAcceptor<SigSignOut> fn)
  {
    cbSessionSigSignOut = fn;
  }

  public void setCbSessionSigTopic(ISigPushAcceptor<SigTopic> fn)
  {
    cbSessionSigTopic = fn;
  }

  public void setCbSessionSigTopicAnalyticEvent(ISigPushAcceptor<SigTopicAnalyticEvent> fn)
  {
    cbSessionSigTopicAnalyticEvent = fn;
  }

  public void setCbSessionSigTopicGroupTyping(ISigPushAcceptor<SigTopicGroupTyping> fn)
  {
    cbSessionSigTopicGroupTyping = fn;
  }

  public void setCbSessionSigTopicMessageNew(ISigPushAcceptor<SigTopicMessageNew> fn)
  {
    cbSessionSigTopicMessageNew = fn;
  }

  public void setCbSessionSigTopicMessageProps(ISigPushAcceptor<SigTopicMessageProps> fn)
  {
    cbSessionSigTopicMessageProps = fn;
  }

  public void setCbAgentSigTopicPluginApiRequest(ISigPushAcceptor<SigTopicPluginApiRequest> fn)
  {
    cbAgentSigTopicPluginApiRequest = fn;
  }

  public void setCbSessionSigTopicSpreadsheetRef(ISigPushAcceptor<SigTopicSpreadsheetRef> fn)
  {
    cbSessionSigTopicSpreadsheetRef = fn;
  }

  public SignalPushAcceptor<? extends ISig> getSignalPushAcceptor(ServiceName serviceName,
    String sigName)
  {
    if(serviceName == ServiceName.agent)
    {
      if(sigName.equals("SigTopicPluginApiRequest"))
      {
        if(cbAgentSigTopicPluginApiRequest != null)
        {
          return new SignalPushAcceptor<>(SigTopicPluginApiRequest.class,
            cbAgentSigTopicPluginApiRequest);
        }
      }
    }
    else if(serviceName == ServiceName.session)
    {
      if(sigName.equals("SigSignOut"))
      {
        if(cbSessionSigSignOut != null)
        {
          return new SignalPushAcceptor<>(SigSignOut.class, cbSessionSigSignOut);
        }
      }
      else if(sigName.equals("SigTopic"))
      {
        if(cbSessionSigTopic != null)
        {
          return new SignalPushAcceptor<>(SigTopic.class, cbSessionSigTopic);
        }
      }
      else if(sigName.equals("SigTopicAnalyticEvent"))
      {
        if(cbSessionSigTopicAnalyticEvent != null)
        {
          return new SignalPushAcceptor<>(SigTopicAnalyticEvent.class,
            cbSessionSigTopicAnalyticEvent);
        }
      }
      else if(sigName.equals("SigTopicGroupTyping"))
      {
        if(cbSessionSigTopicGroupTyping != null)
        {
          return new SignalPushAcceptor<>(SigTopicGroupTyping.class, cbSessionSigTopicGroupTyping);
        }
      }
      else if(sigName.equals("SigTopicMessageNew"))
      {
        if(cbSessionSigTopicMessageNew != null)
        {
          return new SignalPushAcceptor<>(SigTopicMessageNew.class, cbSessionSigTopicMessageNew);
        }
      }
      else if(sigName.equals("SigTopicMessageProps"))
      {
        if(cbSessionSigTopicMessageProps != null)
        {
          return new SignalPushAcceptor<>(SigTopicMessageProps.class,
            cbSessionSigTopicMessageProps);
        }
      }
      else if(sigName.equals("SigTopicSpreadsheetRef"))
      {
        if(cbSessionSigTopicSpreadsheetRef != null)
        {
          return new SignalPushAcceptor<>(SigTopicSpreadsheetRef.class,
            cbSessionSigTopicSpreadsheetRef);
        }
      }
    }

    return null;
  }
  public static class SignalPushAcceptor<S extends ISig>
  {
    public final Class<S> signalClass;
    private final ISigPushAcceptor<S> pushAcceptor;

    public SignalPushAcceptor(Class<S> signalClass, ISigPushAcceptor<S> pushAcceptor)
    {
      this.signalClass = signalClass;
      this.pushAcceptor = pushAcceptor;
    }

    public void execute(ISig sig)
    {
      //noinspection unchecked
      pushAcceptor.execute((S) sig);
    }
  }
}
