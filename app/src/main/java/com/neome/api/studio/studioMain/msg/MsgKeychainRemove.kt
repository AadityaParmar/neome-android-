// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.KeychainId
import com.neome.api.nucleus.base.msg.Msg

open class MsgKeychainRemove : Msg()
{
  lateinit var keychainId: KeychainId
}