package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldSetOfRole
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldSetOfRoleData(
    override val displaySet: Array<String>? = null,
    override val valueSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>
) : FieldSetOfRole
