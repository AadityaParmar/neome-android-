// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldImage : StudioFieldEditable() {
    var defaultImage: FieldDtoImage? = null
    var defaultImageFieldId: MetaIdField? = null
    var defaultImageVarId: MetaIdVar? = null
    var maxSize: number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVarId: MetaIdVar? = null
    var showLabel: boolean? = null
    var showLabelFieldId: MetaIdField? = null
    var showLabelVarId: MetaIdVar? = null
    var showPreview: boolean? = null
    var showPreviewFieldId: MetaIdField? = null
    var showPreviewVarId: MetaIdVar? = null
    var showSize: boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVarId: MetaIdVar? = null
}
