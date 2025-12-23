// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLogOperationKind
import com.neome.api.meta.base.Types.MetaIdField

open class EntVdRowUpdateFieldLogNumber : EntVdAutoStepWithError() {
    var inputField: StudioBuildArgBinder? = null
    var operation: EnumDefnLogOperationKind? = null
    var operationMessage: StudioValueText? = null
    var outputLogNumberFieldId: MetaIdField? = null
    var rowIdPointer: StudioDtoRowIdPointer? = null
}
