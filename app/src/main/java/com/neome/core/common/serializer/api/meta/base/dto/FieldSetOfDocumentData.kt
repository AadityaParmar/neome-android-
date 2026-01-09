package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.dto.FieldSetOfDocument
import com.neome.core.common.serializer.sysId.MediaIdDocumentSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldSetOfDocumentData(
    override val fileExtSet: Array<EnumDefnDocFileExt>,
    override val fileNameSet: Array<String>,
    override val fileSizeSet: Array<Long>,
    override val mediaIdDocumentSet: Array<@Serializable(with = MediaIdDocumentSer::class) Types.MediaIdDocument>
) : FieldSetOfDocument
