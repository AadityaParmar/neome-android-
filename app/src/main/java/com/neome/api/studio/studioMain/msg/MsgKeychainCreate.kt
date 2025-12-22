// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.EnumKeychainType
import com.neome.api.meta.base.Types.KeychainId
import com.neome.api.meta.base.Types.KeychainSecretId
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.studio.base.dto.DtoSecretKeyBase

class MsgKeychainCreate : Msg() {
    var description: string? = null
    val keychainId: KeychainId
    val name: string
    var secretKey: string? = null
    var secretKeyMap: Record<KeychainSecretId, DtoSecretKeyBase>? = null
    val type: EnumKeychainType
}
