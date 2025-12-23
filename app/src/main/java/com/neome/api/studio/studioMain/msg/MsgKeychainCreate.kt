// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.EnumKeychainType
import com.neome.api.meta.base.Types.KeychainId
import com.neome.api.meta.base.Types.KeychainSecretId
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.studio.base.dto.DtoSecretKeyBase
import java.util.Map

open class MsgKeychainCreate : Msg() {
    var description: String? = null
    lateinit var keychainId: KeychainId
    lateinit var name: String
    var secretKey: String? = null
    var secretKeyMap: Map<KeychainSecretId, DtoSecretKeyBase>? = null
    lateinit var type: EnumKeychainType
}
