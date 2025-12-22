// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli

import com.neome.api.app.cli.msg.MsgNeoScriptCtxSet
import com.neome.api.app.cli.msg.MsgNeoScriptGet
import com.neome.api.app.cli.msg.MsgNeoScriptPut
import com.neome.api.app.cli.sig.SigNeoScriptGet
import com.neome.api.app.cli.sig.SigNeoScriptPut
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor

class WsocCli {
    companion object {
        val SN: ServiceName = ServiceName.cli

        fun neoScriptCtxSet(
            entId: EntId,
            msg: MsgNeoScriptCtxSet,
            sigAcceptor: ISigAcceptor<SigNeoScriptPut>
        ) {
            CallFactory.wsoc.create(SigNeoScriptPut::class.java, entId, SN, "neoScriptCtxSet")
                .put(msg, sigAcceptor)
        }

        fun neoScriptGet(msg: MsgNeoScriptGet, sigAcceptor: ISigAcceptor<SigNeoScriptGet>) {
            CallFactory.wsoc.create(
                SigNeoScriptGet::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "neoScriptGet"
            )
                .get(msg, sigAcceptor)
        }

        fun neoScriptPut(msg: MsgNeoScriptPut, sigAcceptor: ISigAcceptor<SigNeoScriptPut>) {
            CallFactory.wsoc.create(
                SigNeoScriptPut::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "neoScriptPut"
            )
                .put(msg, sigAcceptor)
        }
    }
}
