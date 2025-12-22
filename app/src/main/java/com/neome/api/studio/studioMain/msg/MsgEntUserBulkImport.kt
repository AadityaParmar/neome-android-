// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.studio.base.dto.DtoEntUserImport

class MsgEntUserBulkImport : Msg() {
    val users: DtoEntUserImport[]
}
