// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.dto.StudioEntDeployPluginMap
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntPluginMapUpdate : Msg() {
    lateinit var pluginMap: StudioEntDeployPluginMap
}
