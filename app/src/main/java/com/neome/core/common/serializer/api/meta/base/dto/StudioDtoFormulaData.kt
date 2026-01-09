package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFormula
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormulaSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoFormulaData(
    @Serializable(with = MetaIdFieldSer::class) override val assignToFieldId: Types.MetaIdField,
    override val conditionVarId: StudioValueVarIdCondition? = null,
    override val formula: StudioValueCodeJavascript? = null,
    @Serializable(with = MetaIdFormulaSer::class) override val metaId: Types.MetaIdFormula,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null
) : StudioDtoFormula
