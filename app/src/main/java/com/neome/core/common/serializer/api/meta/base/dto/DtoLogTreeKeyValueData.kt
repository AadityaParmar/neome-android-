package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.DtoLogTreeKeyValueType
import com.neome.api.meta.base.Types.EnumLogTreeItemType
import com.neome.api.meta.base.dto.DtoLogTreeItem
import com.neome.api.meta.base.dto.DtoLogTreeKeyValue
import kotlinx.serialization.Serializable


@Serializable
data class DtoLogTreeKeyValueData(
    override val bgColor: String? = null,
    override val id: String,
    override val type: EnumLogTreeItemType,
    override val children: Array<DtoLogTreeKeyValue>? = null,
    override val keyColor: String? = null,
    override val keyText: String,
    override val keyTooltip: Boolean? = null,
    override val keyWidth: Long? = null,
    override val value: String? = null,
    override val valueColor: String? = null,
    override val valueTooltip: Boolean? = null,
    override val valueType: DtoLogTreeKeyValueType? = null
) : DtoLogTreeKeyValue
