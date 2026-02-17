package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPluginAuthMethod
import com.neome.api.meta.base.dto.StudioMapOfValueText
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.dto.StudioPluginAuthBase
import com.neome.api.meta.base.dto.StudioPluginAuthOAuth
import com.neome.api.meta.base.dto.StudioValueText
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfValueTextData
import com.neome.core.common.serializer.api.meta.base.dto.StudioModuleSelectionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueTextData
import com.neome.core.common.serializer.sysId.MetaIdAuthMethodSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginAuthOAuthData(
    override val description: String? = null,
    override val kind: EnumDefnPluginAuthMethod,
    @Serializable(with = MetaIdAuthMethodSer::class) override val metaId: Types.MetaIdAuthMethod,
    override val modules: StudioModuleSelectionData? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val additionalProperties: StudioMapOfValueTextData? = null,
    override val authEndPoint: StudioValueTextData? = null,
    override val clientId: StudioValueTextData? = null,
    override val clientSecret: StudioValueTextData? = null,
    override val scopes: StudioValueTextData? = null,
    override val tokenEndPoint: StudioValueTextData? = null
) : StudioPluginAuthOAuth
