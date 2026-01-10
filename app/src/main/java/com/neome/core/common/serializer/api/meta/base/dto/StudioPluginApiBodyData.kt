package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginApiBody
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueCodeJavascriptData
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginApiBodyData(
    override val declarative: StudioValueCodeJavascriptData? = null,
    override val script: StudioValueCodeJavascriptData? = null
) : StudioPluginApiBody
