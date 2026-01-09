package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueAudio
import com.neome.core.common.serializer.sysId.MediaIdAudioSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueAudioData(
    override val durationMs: Long? = null,
    override val fileName: String,
    override val fileSize: Long? = null,
    @Serializable(with = MediaIdAudioSer::class) override val mediaIdAudio: Types.MediaIdAudio
) : FieldValueAudio
