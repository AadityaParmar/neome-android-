// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.extn

import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.core.extn.msg.MsgExtnGstinDetailsGet
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.core.extn.sig.SigExtnGstinDetails

class RpcExtn {
    companion object {
        val SN: ServiceName = ServiceName.extn

        fun extnGstinDetailsGet(
            msg: MsgExtnGstinDetailsGet,
            sigAcceptor: ISigAcceptor<SigExtnGstinDetails>
        ) {
            CallFactory.rpc.create(
                SigExtnGstinDetails::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "extnGstinDetailsGet"
            )
                .get(msg, sigAcceptor)
        }
    }
}
