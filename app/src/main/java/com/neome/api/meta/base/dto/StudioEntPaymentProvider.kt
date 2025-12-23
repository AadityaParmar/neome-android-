// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumPaymentProviderKind
import com.neome.api.meta.base.Types.MetaIdPaymentProvider
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.Symbol

open class StudioEntPaymentProvider : StudioBase()
{
  lateinit var kind: EnumPaymentProviderKind
  lateinit var metaId: MetaIdPaymentProvider
  var name: Symbol? = null
}