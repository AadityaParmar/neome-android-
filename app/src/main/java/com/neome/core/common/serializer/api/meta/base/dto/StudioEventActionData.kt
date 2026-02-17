package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindEventAction
import com.neome.api.meta.base.Types.EnumDefnKindEventActionOn
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioEventAction
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueCodeJavascriptData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdFormEventActionSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEventActionData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction? = null,
    override val actionOn: EnumDefnKindEventActionOn? = null,
    override val compIdSet: List<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp>? = null,
    override val formula: StudioValueCodeJavascriptData? = null,
    override val groupIdSet: List<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup>? = null,
    override val kind: EnumDefnKindEventAction,
    override val layoutIdSet: List<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    @Serializable(with = MetaIdVarSer::class) override val mappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFormEventActionSer::class) override val metaId: Types.MetaIdFormEventAction,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val source: StudioBuildArgBinderData? = null
) : StudioEventAction
