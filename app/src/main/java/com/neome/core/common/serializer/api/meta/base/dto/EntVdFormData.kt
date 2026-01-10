package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdForm
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.api.meta.base.dto.FormRefKeyData
import com.neome.core.common.serializer.sysId.GhostIdSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdFormData(
    override val form: FormRefKeyData? = null,
    @Serializable(with = GhostIdSer::class) override val metaId: Types.GhostId
) : EntVdForm
