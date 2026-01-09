package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDeeplinkConstraint
import com.neome.api.meta.base.Types.EnumDefnDeeplinkExpiry
import com.neome.api.meta.base.Types.EnumDefnKindDeeplink
import com.neome.api.meta.base.Types.EnumDefnUserProps
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeeplink
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.core.common.serializer.sysId.MetaIdDeeplinkSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDeeplinkData(
    override val creationRoles: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val description: String? = null,
    override val expiry: EnumDefnDeeplinkExpiry? = null,
    override val kind: EnumDefnKindDeeplink,
    override val makeUserDefaultRoles: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdDeeplinkSer::class) override val metaId: Types.MetaIdDeeplink,
    override val modules: StudioModuleSelection? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val showEnterpriseImageInLinkPreview: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val targetUserHandleFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val targetUserSpreadsheetId: Types.MetaIdSpreadsheet? = null,
    override val userFieldMap: Map<EnumDefnUserProps, @Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val visibilityConstraint: EnumDefnDeeplinkConstraint? = null
) : StudioEntDeeplink
