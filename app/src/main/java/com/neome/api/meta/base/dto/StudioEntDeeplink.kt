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
import java.util.Map

open class StudioEntDeeplink : StudioBase() {
    var creationRoles: Array<MetaIdRole>? = null
    var description: String? = null
    var expiry: EnumDefnDeeplinkExpiry? = null
    lateinit var kind: EnumDefnKindDeeplink
    var makeUserDefaultRoles: Array<MetaIdRole>? = null
    lateinit var metaId: MetaIdDeeplink
    var modules: StudioModuleSelection? = null
    lateinit var name: Symbol
    var showEnterpriseImageInLinkPreview: Boolean? = null
    var targetUserHandleFieldId: MetaIdField? = null
    var targetUserSpreadsheetId: MetaIdSpreadsheet? = null
    var userFieldMap: Map<EnumDefnUserProps, MetaIdField>? = null
    var visibilityConstraint: EnumDefnDeeplinkConstraint? = null
}
