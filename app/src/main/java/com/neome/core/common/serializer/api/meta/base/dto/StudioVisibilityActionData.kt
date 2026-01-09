package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnVisibilityAction
import com.neome.api.meta.base.Types.EnumDefnVisibilityActionOn
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioVisibilityAction
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.MetaIdVisibilityActionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVisibilityActionData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction? = null,
    override val compIdSet: Array<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp>? = null,
    override val groupIdSet: Array<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup>? = null,
    override val layoutIdSet: Array<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    @Serializable(with = MetaIdVarSer::class) override val mappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVisibilityActionSer::class) override val metaId: Types.MetaIdVisibilityAction,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val source: StudioBuildArgBinder? = null,
    override val visibilityAction: EnumDefnVisibilityAction,
    override val visibilityActionOn: EnumDefnVisibilityActionOn? = null
) : StudioVisibilityAction
