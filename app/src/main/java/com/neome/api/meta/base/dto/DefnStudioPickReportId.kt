// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport

interface DefnStudioPickReportId : DefnField {
    val excludeReportIdSet: List<MetaIdReport>?
}
