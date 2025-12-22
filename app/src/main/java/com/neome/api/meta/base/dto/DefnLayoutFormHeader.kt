// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdHyperlink
import com.neome.api.meta.base.Types.MetaIdLayoutForm

class DefnLayoutFormHeader {
    var backgroundColor: DefnDtoColor? = null
    var backgroundColorVar: DefnDtoColor? = null
    var formLayoutId: MetaIdLayoutForm? = null
    var headerImage: FieldDtoImage? = null
    var headerImageHeight: number? = null
    var headerImageVar: FieldDtoImage? = null
    var hyperLinkMap: Record<MetaIdHyperlink, DefnDtoHyperLink>? = null
    var hyperlinkKeys: MetaIdHyperlink[]? = null
    var showEnterprise: boolean? = null
    var showSeparator: boolean? = null
    var textColor: DefnDtoColor? = null
    var textColorVar: DefnDtoColor? = null
}
