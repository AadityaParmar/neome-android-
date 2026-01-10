package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutFormFooter
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutFormFooterData(
    override val footerImage: FieldDtoImageData? = null,
    override val footerImageHeight: Long? = null,
    @Serializable(with = MetaIdVarSer::class) override val footerImageVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formLayoutId: Types.MetaIdLayoutForm? = null,
    override val showSeparator: Boolean? = null
) : StudioDtoLayoutFormFooter
