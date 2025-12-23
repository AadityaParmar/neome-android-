// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.meta.base.Types.HandleKey
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

open class SigEntUserBulkImport : Sig()
{
  lateinit var errorMap: Map<HandleKey, EnvValidationError>
}