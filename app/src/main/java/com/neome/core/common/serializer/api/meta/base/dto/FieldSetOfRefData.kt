package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldSetOfRef
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldSetOfRefData(
    override val displaySet: Array<String>,
    override val valueSet: Array<@Serializable(with = RowIdSer::class) Types.RowId>,
    override val versionSet: Array<String>
) : FieldSetOfRef
