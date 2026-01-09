package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptLayout
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptLayoutData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formLayoutId: Types.MetaIdLayoutForm? = null
) : DtoNeoScriptLayout
