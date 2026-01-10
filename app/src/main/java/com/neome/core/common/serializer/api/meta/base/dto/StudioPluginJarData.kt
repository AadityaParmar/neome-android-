package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfJarFile
import com.neome.api.meta.base.dto.StudioPluginJar
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfJarFileData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginJarData(
    override val lastUpdateTime: String,
    @Serializable(with = MetaIdVarSer::class) override val packageNameVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFormSer::class) override val pluginConfigFormId: Types.MetaIdForm? = null,
    override val uploadJarMap: StudioMapOfJarFileData? = null
) : StudioPluginJar
