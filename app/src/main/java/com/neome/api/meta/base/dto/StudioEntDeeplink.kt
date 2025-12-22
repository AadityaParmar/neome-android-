// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnDeeplinkConstraint
import com.neome.api.meta.base.Types.EnumDefnDeeplinkExpiry
import com.neome.api.meta.base.Types.EnumDefnKindDeeplink
import com.neome.api.meta.base.Types.EnumDefnUserProps
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioEntDeeplink : StudioBase() {
    var creationRoles: MetaIdRole[]? = null
    var description: string? = null
    var expiry: EnumDefnDeeplinkExpiry? = null
    val kind: EnumDefnKindDeeplink
    var makeUserDefaultRoles: MetaIdRole[]? = null
    val metaId: MetaIdDeeplink
    var modules: StudioModuleSelection? = null
    val name: Symbol
    var showEnterpriseImageInLinkPreview: boolean? = null
    var targetUserHandleFieldId: MetaIdField? = null
    var targetUserSpreadsheetId: MetaIdSpreadsheet? = null
    var userFieldMap: Record<EnumDefnUserProps, MetaIdField>? = null
    var visibilityConstraint: EnumDefnDeeplinkConstraint? = null
}
