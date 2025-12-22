// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.nucleus.base.msg.Msg

class MsgAddressBookContact : Msg() {
    val handle: string
    val nickName: string
}
