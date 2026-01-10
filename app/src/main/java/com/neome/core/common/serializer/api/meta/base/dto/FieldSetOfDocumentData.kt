package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.dto.FieldSetOfDocument
import com.neome.core.common.serializer.sysId.MediaIdDocumentSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldSetOfDocumentData(
    override val fileExtSet: List<EnumDefnDocFileExt>,
    override val fileNameSet: List<String>,
    override val fileSizeSet: List<Long>,
    override val mediaIdDocumentSet: List<@Serializable(with = MediaIdDocumentSer::class) Types.MediaIdDocument>
) : FieldSetOfDocument
