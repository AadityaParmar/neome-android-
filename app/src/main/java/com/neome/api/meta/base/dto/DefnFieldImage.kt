// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldImage : DefnFieldEditable() {
    var defaultImage: FieldDtoImage? = null
    var defaultImageFieldId: MetaIdField? = null
    var defaultImageVar: FieldDtoImage? = null
    var flexWidth: boolean? = null
    var height: number? = null
    var maxSize: number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVar: number? = null
    var showLabel: boolean? = null
    var showLabelFieldId: MetaIdField? = null
    var showLabelVar: boolean? = null
    var showPreview: boolean? = null
    var showPreviewFieldId: MetaIdField? = null
    var showPreviewVar: boolean? = null
    var showSize: boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVar: boolean? = null
}
