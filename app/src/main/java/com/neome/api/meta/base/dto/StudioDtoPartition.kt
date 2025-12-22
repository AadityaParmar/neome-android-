// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPartition

class StudioDtoPartition : StudioBase() {
    val assignPartitionFieldId: MetaIdField
    val formula: StudioValueCodeJavascript
    val metaId: MetaIdPartition
    val name: Symbol
}
