// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEmptyFieldVariant
import com.neome.api.meta.base.Types.EnumDefnInsertVariant
import com.neome.api.meta.base.Types.EnumDefnRemoveVariant
import com.neome.api.meta.base.Types.EnumDefnUpdateVariant
import com.neome.api.meta.base.Types.MetaIdField

open class StudioDtoMappingFieldMap : StudioDtoMappingFieldMapBase() {
    var emptyFieldVariant: EnumDefnEmptyFieldVariant? = null
    var fromKey: MetaIdField? = null
    var insertVariant: EnumDefnInsertVariant? = null
    var removeVariant: EnumDefnRemoveVariant? = null
    var toKey: MetaIdField? = null
    var updateVariant: EnumDefnUpdateVariant? = null
}
