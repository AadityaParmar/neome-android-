package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptMenu
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptMenuData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdCompositeSer::class) override val compositeId: Types.MetaIdComposite? = null,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm? = null
) : DtoNeoScriptMenu
