package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoJarFile
import com.neome.api.meta.base.dto.StudioMapOfJarFile
import com.neome.core.common.serializer.sysId.MediaIdJarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfJarFileData(
    override val keys: Array<@Serializable(with = MediaIdJarSer::class) Types.MediaIdJar>,
    override val map: Map<@Serializable(with = MediaIdJarSer::class) Types.MediaIdJar, StudioDtoJarFile>
) : StudioMapOfJarFile
