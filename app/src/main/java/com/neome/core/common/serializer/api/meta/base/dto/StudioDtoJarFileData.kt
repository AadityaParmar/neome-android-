package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoJarFile
import com.neome.core.common.serializer.sysId.MediaIdJarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoJarFileData(
    override val fileName: String,
    override val md5: String,
    @Serializable(with = MediaIdJarSer::class) override val metaId: Types.MediaIdJar
) : StudioDtoJarFile
