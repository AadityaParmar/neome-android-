package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueAudio
import com.neome.api.meta.base.dto.FieldValueEntUserId
import com.neome.api.meta.base.dto.FieldValueLocation
import com.neome.api.meta.base.dto.FieldValueVoice
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueLocationData
import com.neome.core.common.serializer.sysId.MediaIdAudioSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueVoiceData(
    override val durationMs: Long,
    override val fileName: String,
    override val fileSize: Long,
    @Serializable(with = MediaIdAudioSer::class) override val mediaIdAudio: Types.MediaIdAudio,
    override val captureLocation: FieldValueLocationData? = null,
    override val captureTime: String? = null,
    override val captureUser: FieldValueEntUserIdData? = null
) : FieldValueVoice
