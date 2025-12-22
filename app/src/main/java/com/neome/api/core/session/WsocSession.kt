// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.session

import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone

class WsocSession {
    companion object {
        val SN: ServiceName = ServiceName.session

        fun sessionPut(sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.wsoc.create(SigDone::class.java, ApiPlus.ENT_ID_GLOBAL, SN, "sessionPut")
                .put(null, sigAcceptor)
        }
    }
}
