// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

interface StudioFieldMap : StudioBase {
    val keys: List<MetaIdField>
    val map: Map<MetaIdField, StudioField>
}
