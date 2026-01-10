package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnVisibilityAction
import com.neome.api.meta.base.Types.EnumDefnVisibilityActionOn
import com.neome.api.meta.base.dto.DefnVisibilityAction
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoArgData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.MetaIdVisibilityActionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnVisibilityActionData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction? = null,
    override val compIdSet: List<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp>? = null,
    override val groupIdSet: List<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup>? = null,
    override val layoutIdSet: List<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    @Serializable(with = MetaIdVarSer::class) override val mappingVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVisibilityActionSer::class) override val metaId: Types.MetaIdVisibilityAction,
    override val source: FieldDtoArgData? = null,
    override val visibilityAction: EnumDefnVisibilityAction,
    override val visibilityActionOn: EnumDefnVisibilityActionOn? = null
) : DefnVisibilityAction
