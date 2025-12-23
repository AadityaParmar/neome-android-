// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api

import com.neome.api.core.session.sig.SigSignOut
import com.neome.api.core.session.sig.SigTopic
import com.neome.api.core.session.sig.SigTopicAnalyticEvent
import com.neome.api.ent.agent.sig.SigTopicPluginApiRequest
import com.neome.api.ent.session.sig.SigTopicSpreadsheetRef
import com.neome.api.home.session.sig.SigTopicGroupTyping
import com.neome.api.home.session.sig.SigTopicMessageNew
import com.neome.api.home.session.sig.SigTopicMessageProps
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.meta.base.sig.ISig
import com.neome.api.nucleus.base.ISigPushAcceptor

class PushSigs {
    private var cbSessionSigSignOut: ISigPushAcceptor<SigSignOut>? = null
    private var cbSessionSigTopic: ISigPushAcceptor<SigTopic>? = null
    private var cbSessionSigTopicAnalyticEvent: ISigPushAcceptor<SigTopicAnalyticEvent>? = null
    private var cbSessionSigTopicGroupTyping: ISigPushAcceptor<SigTopicGroupTyping>? = null
    private var cbSessionSigTopicMessageNew: ISigPushAcceptor<SigTopicMessageNew>? = null
    private var cbSessionSigTopicMessageProps: ISigPushAcceptor<SigTopicMessageProps>? = null
    private var cbAgentSigTopicPluginApiRequest: ISigPushAcceptor<SigTopicPluginApiRequest>? = null
    private var cbSessionSigTopicSpreadsheetRef: ISigPushAcceptor<SigTopicSpreadsheetRef>? = null

    fun setCbSessionSigSignOut(fn: ISigPushAcceptor<SigSignOut>) {
        cbSessionSigSignOut = fn
    }

    fun setCbSessionSigTopic(fn: ISigPushAcceptor<SigTopic>) {
        cbSessionSigTopic = fn
    }

    fun setCbSessionSigTopicAnalyticEvent(fn: ISigPushAcceptor<SigTopicAnalyticEvent>) {
        cbSessionSigTopicAnalyticEvent = fn
    }

    fun setCbSessionSigTopicGroupTyping(fn: ISigPushAcceptor<SigTopicGroupTyping>) {
        cbSessionSigTopicGroupTyping = fn
    }

    fun setCbSessionSigTopicMessageNew(fn: ISigPushAcceptor<SigTopicMessageNew>) {
        cbSessionSigTopicMessageNew = fn
    }

    fun setCbSessionSigTopicMessageProps(fn: ISigPushAcceptor<SigTopicMessageProps>) {
        cbSessionSigTopicMessageProps = fn
    }

    fun setCbAgentSigTopicPluginApiRequest(fn: ISigPushAcceptor<SigTopicPluginApiRequest>) {
        cbAgentSigTopicPluginApiRequest = fn
    }

    fun setCbSessionSigTopicSpreadsheetRef(fn: ISigPushAcceptor<SigTopicSpreadsheetRef>) {
        cbSessionSigTopicSpreadsheetRef = fn
    }

    class SignalPushAcceptor<S : ISig>(
        val signalClass: Class<S>,
        private val pushAcceptor: ISigPushAcceptor<S>
    ) {
        fun execute(sig: ISig) {
            @Suppress("UNCHECKED_CAST")
            pushAcceptor.execute(sig as S)
        }
    }

    fun getSignalPushAcceptor(
        serviceName: ServiceName,
        sigName: String
    ): SignalPushAcceptor<out ISig>? {
        if (serviceName == ServiceName.agent) {
            if (sigName == "SigTopicPluginApiRequest") {
                cbAgentSigTopicPluginApiRequest?.let()
                {

                    return SignalPushAcceptor(SigTopicPluginApiRequest::class.java, it)
                }
            }
        } else if (serviceName == ServiceName.session) {
            if (sigName == "SigSignOut") {
                cbSessionSigSignOut?.let()
                {
                    return SignalPushAcceptor(SigSignOut::class.java, it)
                }
            } else if (sigName == "SigTopic") {
                cbSessionSigTopic?.let()
                {
                    return SignalPushAcceptor(SigTopic::class.java, it)
                }
            } else if (sigName == "SigTopicAnalyticEvent") {
                cbSessionSigTopicAnalyticEvent?.let()
                {
                    return SignalPushAcceptor(SigTopicAnalyticEvent::class.java, it)
                }
            } else if (sigName == "SigTopicGroupTyping") {
                cbSessionSigTopicGroupTyping?.let()
                {
                    return SignalPushAcceptor(SigTopicGroupTyping::class.java, it)
                }
            } else if (sigName == "SigTopicMessageNew") {
                cbSessionSigTopicMessageNew?.let()
                {
                    return SignalPushAcceptor(SigTopicMessageNew::class.java, it)
                }
            } else if (sigName == "SigTopicMessageProps") {
                cbSessionSigTopicMessageProps?.let()
                {
                    return SignalPushAcceptor(SigTopicMessageProps::class.java, it)
                }
            } else if (sigName == "SigTopicSpreadsheetRef") {
                cbSessionSigTopicSpreadsheetRef?.let()
                {
                    return SignalPushAcceptor(SigTopicSpreadsheetRef::class.java, it)
                }
            }
        }

        return null
    }
}
