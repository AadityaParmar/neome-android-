// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.dto.StudioEnt
import com.neome.api.nucleus.base.msg.Msg

open class MsgStudioEntCreate : Msg() {
    lateinit var adminId: AdminId
    lateinit var studioEnt: StudioEnt
}
