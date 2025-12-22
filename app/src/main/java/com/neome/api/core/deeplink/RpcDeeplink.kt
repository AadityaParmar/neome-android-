// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink

import com.neome.api.core.deeplink.msg.MsgDeeplinkCode
import com.neome.api.core.deeplink.msg.MsgDeeplinkCodeAction
import com.neome.api.core.deeplink.msg.MsgDeeplinkHtml
import com.neome.api.core.deeplink.sig.SigDeeplinkData
import com.neome.api.core.deeplink.sig.SigDeeplinkHtml
import com.neome.api.core.deeplink.sig.SigDeeplinkPreview
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.ApiPlus
import com.neome.api.nucleus.base.CallFactory
import com.neome.api.nucleus.base.ISigAcceptor
import com.neome.api.nucleus.base.sig.SigCallback

class RpcDeeplink {
    companion object {
        val SN: ServiceName = ServiceName.deeplink

        fun deeplinkAction(msg: MsgDeeplinkCodeAction, sigAcceptor: ISigAcceptor<SigCallback>) {
            CallFactory.rpc.create(
                SigCallback::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "deeplinkAction"
            )
                .sendRefreshToken()
                .post(msg, sigAcceptor)
        }

        fun deeplinkDataGet(msg: MsgDeeplinkCode, sigAcceptor: ISigAcceptor<SigDeeplinkData>) {
            CallFactory.rpc.create(
                SigDeeplinkData::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "deeplinkDataGet"
            )
                .sendRefreshToken()
                .get(msg, sigAcceptor)
        }

        fun deeplinkHtmlGet(msg: MsgDeeplinkHtml, sigAcceptor: ISigAcceptor<SigDeeplinkHtml>) {
            CallFactory.rpc.create(
                SigDeeplinkHtml::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "deeplinkHtmlGet"
            )
                .get(msg, sigAcceptor)
        }

        fun deeplinkPreviewGet(
            msg: MsgDeeplinkCode,
            sigAcceptor: ISigAcceptor<SigDeeplinkPreview>
        ) {
            CallFactory.rpc.create(
                SigDeeplinkPreview::class.java,
                ApiPlus.ENT_ID_GLOBAL,
                SN,
                "deeplinkPreviewGet"
            )
                .get(msg, sigAcceptor)
        }
    }
}
