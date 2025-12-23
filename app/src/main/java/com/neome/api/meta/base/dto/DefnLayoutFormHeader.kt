// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdHyperlink
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import java.util.Map

open class DefnLayoutFormHeader {
    var backgroundColor: DefnDtoColor? = null
    var backgroundColorVar: DefnDtoColor? = null
    var formLayoutId: MetaIdLayoutForm? = null
    var headerImage: FieldDtoImage? = null
    var headerImageHeight: Number? = null
    var headerImageVar: FieldDtoImage? = null
    var hyperLinkMap: Map<MetaIdHyperlink, DefnDtoHyperLink>? = null
    var hyperlinkKeys: Array<MetaIdHyperlink>? = null
    var showEnterprise: Boolean? = null
    var showSeparator: Boolean? = null
    var textColor: DefnDtoColor? = null
    var textColorVar: DefnDtoColor? = null
}
