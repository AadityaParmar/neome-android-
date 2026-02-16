package com.neome.feature.form.domain.util.FieldVal

import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoGridRowData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.feature.form.domain.DefnFormUi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

internal interface DefaultValue {

    fun fnEnsureInit(
        defnFormData: DefnFormUi,
        formValue: FormValueData?,
        defaultValue: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>?
    ) {
    }

    fun fnEnsureInitGridRow(
        defnFormData: DefnFormUi,
        gridRow: FieldDtoGridRowData?,
        defaultValue: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>?
    ) {

    }

    private fun resolveCompDefaultValue() {

    }

}
