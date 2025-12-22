// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.nucleus.base.msg.Msg

class MsgPluginApiSpecGet : Msg() {
    val metaIdPlugin: MetaIdPlugin
}
