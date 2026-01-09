package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumFormContentPosition
import com.neome.api.meta.base.Types.EnumLogItemType
import com.neome.api.meta.base.Types.EnumLogTextType
import com.neome.api.meta.base.dto.DtoLogItem
import com.neome.api.meta.base.dto.DtoLogText
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTextData(
    override val id: String,
    override val type: EnumLogItemType,
    override val bgColor: String,
    override val bold: Boolean? = null,
    override val caption: String? = null,
    override val child: DtoLogItem? = null,
    override val contentPosition: EnumFormContentPosition? = null,
    override val executable: Boolean? = null,
    override val iconEnd: String? = null,
    override val iconEndColor: String? = null,
    override val iconStart: String? = null,
    override val iconStartColor: String? = null,
    override val showChildDivider: Boolean? = null,
    override val text: String,
    override val textColor: String? = null,
    override val textType: EnumLogTextType? = null
) : DtoLogText
