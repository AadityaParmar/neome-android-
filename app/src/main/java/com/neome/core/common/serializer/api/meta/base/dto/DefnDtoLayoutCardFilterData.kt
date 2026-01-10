package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnLayoutCardFilterKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.dto.DefnDtoLayoutCardFilter
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutCardFilterData(
    override val advanceFilterFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val categoryFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val kind: EnumDefnLayoutCardFilterKind? = null,
    override val showSearchBar: Boolean? = null,
    override val sortByFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val sortOrder: EnumDefnSortOrder? = null
) : DefnDtoLayoutCardFilter
