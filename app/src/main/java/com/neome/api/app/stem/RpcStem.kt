// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.stem

import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigDone

class RpcStem {
    companion object {
        val SN: ServiceName = ServiceName.stem

        fun migrateArtifacts(sigAcceptor: ISigAcceptor<SigDone>) {
            CallFactory.rpc.create(
                SigDone::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "migrateArtifacts"
            )
                .sendBearerToken()
                .get(null, sigAcceptor)
        }
    }
}
