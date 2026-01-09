package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptFormula
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdFormulaSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptFormulaData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdFormulaSer::class) override val formulaId: Types.MetaIdFormula? = null
) : DtoNeoScriptFormula
