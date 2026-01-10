package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnLayoutFormFooter
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormFooterData(
    override val footerImage: FieldDtoImageData? = null,
    override val footerImageHeight: Long? = null,
    override val footerImageVar: FieldDtoImageData? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formLayoutId: Types.MetaIdLayoutForm? = null,
    override val showSeparator: Boolean? = null
) : DefnLayoutFormFooter
