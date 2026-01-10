package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFuncArg
import com.neome.api.meta.base.dto.StudioMapOfFuncArg
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.api.meta.base.dto.StudioVarValueFunc
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfFuncArgData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueCodeJavascriptData
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueFuncData(
    override val inputFuncArgMap: StudioMapOfFuncArgData? = null,
    override val javascript: StudioValueCodeJavascriptData? = null,
    override val outputKind: EnumDefnFuncArg? = null
) : StudioVarValueFunc
