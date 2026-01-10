package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntFormExportExcel
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DtoGridLayoutRefKey
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.dto.GsonCto
import com.neome.core.common.serializer.api.meta.base.dto.DtoGridLayoutRefKeyData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntFormExportExcelData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValueRaw: FormValueRawData,
    override val layoutRefKeyList: List<DtoGridLayoutRefKeyData>
) : DtoEntFormExportExcel
