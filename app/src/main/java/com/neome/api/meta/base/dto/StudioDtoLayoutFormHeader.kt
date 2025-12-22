// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar

class StudioDtoLayoutFormHeader : StudioBase() {
    var backgroundColor: StudioDtoColor? = null
    var backgroundColorVarId: MetaIdVar? = null
    var formLayoutId: MetaIdLayoutForm? = null
    var headerImage: FieldDtoImage? = null
    var headerImageHeight: number? = null
    var headerImageVarId: MetaIdVar? = null
    var hyperlinkVarIdSet: MetaIdVar[]? = null
    var showEnterprise: boolean? = null
    var showSeparator: boolean? = null
    var textColor: StudioDtoColor? = null
    var textColorVarId: MetaIdVar? = null
}
