package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFormula
import com.neome.api.meta.base.dto.StudioMapOfFormula
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoFormulaData
import com.neome.core.common.serializer.sysId.MetaIdFormulaSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfFormulaData(
    override val keys: List<@Serializable(with = MetaIdFormulaSer::class) Types.MetaIdFormula>? = null,
    override val map: Map<@Serializable(with = MetaIdFormulaSer::class) Types.MetaIdFormula, StudioDtoFormulaData>
) : StudioMapOfFormula
