package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.dto.FieldDtoDocument
import com.neome.core.common.serializer.sysId.MediaIdDocumentSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoDocumentData(
    override val fileExt: EnumDefnDocFileExt,
    override val fileName: String,
    override val fileSize: Long,
    @Serializable(with = MediaIdDocumentSer::class) override val mediaIdDocument: Types.MediaIdDocument
) : FieldDtoDocument
