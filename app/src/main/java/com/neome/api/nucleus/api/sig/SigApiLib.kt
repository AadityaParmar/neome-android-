// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.api.sig

import com.neome.api.nucleus.base.dto.DescApiModule
import com.neome.api.nucleus.base.dto.DescApiPushSigs
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

open class SigApiLib : Sig()
{
  lateinit var api: Map<String, DescApiModule>
  lateinit var pushSigs: DescApiPushSigs
}