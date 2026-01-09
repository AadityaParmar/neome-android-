package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutFormEditorComposite
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormEditorCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutFormEditorCompositeData(
    @Serializable(with = MetaIdCompositeSer::class) override val compositeId: Types.MetaIdComposite,
    @Serializable(with = MetaIdLayoutGridSer::class) override val gridLayoutId: Types.MetaIdLayoutGrid? = null,
    @Serializable(with = MetaIdLayoutFormEditorCompositeSer::class) override val metaId: Types.MetaIdLayoutFormEditorComposite,
    override val sectionDirection: EnumDefnThemeDirection? = null,
    override val sectionVariant: EnumDefnThemeSectionVariant? = null
) : StudioDtoLayoutFormEditorComposite
