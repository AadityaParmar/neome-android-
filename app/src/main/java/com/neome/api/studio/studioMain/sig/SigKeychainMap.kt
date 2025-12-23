// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.studio.base.dto.DtoKeychain
import com.neome.api.meta.base.Types.KeychainId
import java.util.Map
import com.neome.api.nucleus.base.sig.SigVersion

open class SigKeychainMap : SigVersion()
{
  lateinit var keychainMap: Map<KeychainId, DtoKeychain>
}