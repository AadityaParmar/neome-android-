package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPluginJar
import com.neome.api.meta.base.dto.StudioMapOfJarFile
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPluginJarData(
    override val packageNameVar: String? = null,
    @Serializable(with = MetaIdFormSer::class) override val pluginConfigFormId: Types.MetaIdForm? = null,
    override val uploadJarMap: StudioMapOfJarFile? = null
) : StudioEntPluginJar
