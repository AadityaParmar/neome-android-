// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumPaymentProviderKind
import com.neome.api.meta.base.Types.MetaIdPaymentProvider

class DtoPaymentProvider {
    val kind: EnumPaymentProviderKind
    val metaId: MetaIdPaymentProvider
}
