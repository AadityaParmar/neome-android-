// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldImage : DefnFieldEditable() {
    var defaultImage: FieldDtoImage? = null
    var defaultImageFieldId: MetaIdField? = null
    var defaultImageVar: FieldDtoImage? = null
    var flexWidth: Boolean? = null
    var height: Number? = null
    var maxSize: Number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVar: Number? = null
    var showLabel: Boolean? = null
    var showLabelFieldId: MetaIdField? = null
    var showLabelVar: Boolean? = null
    var showPreview: Boolean? = null
    var showPreviewFieldId: MetaIdField? = null
    var showPreviewVar: Boolean? = null
    var showSize: Boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVar: Boolean? = null
}
