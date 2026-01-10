// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.MetaIdField

interface SigOutputFormValue : SigFormValue {
    val outputFieldIdSet: List<MetaIdField>?
}
