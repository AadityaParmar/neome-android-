// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindPipelineUpdate
import com.neome.api.meta.base.Types.MetaIdVar

class EntVdRowUpdate : EntVdAutoStepWithOutputAndError() {
    var option: EnumDefnKindPipelineUpdate? = null
    var outputMapping: StudioDtoMapping? = null
    var outputMappingVarId: MetaIdVar? = null
    var overwriteRow: boolean? = null
    var rowIdPointer: StudioDtoRowIdPointer? = null
}
