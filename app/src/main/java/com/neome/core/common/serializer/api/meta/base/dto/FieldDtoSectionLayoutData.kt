package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.FieldDtoSectionLayout
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoSectionLayoutData(
    override val alignItems: EnumDefnPlacement? = null,
    override val autoSize: Boolean? = null,
    override val backgroundColorVar: DefnDtoColorData? = null,
    override val borderBottom: Boolean? = null,
    override val borderBottomLeftRadius: Long? = null,
    override val borderBottomRightRadius: Long? = null,
    override val borderColor: DefnDtoColorData? = null,
    override val borderLeft: Boolean? = null,
    override val borderRight: Boolean? = null,
    override val borderTop: Boolean? = null,
    override val borderTopLeftRadius: Long? = null,
    override val borderTopRightRadius: Long? = null,
    override val flex: String? = null,
    override val flexGrow: String? = null,
    override val height: String? = null,
    override val justifyContent: EnumDefnPlacement? = null,
    override val maxHeight: String? = null,
    override val maxWidth: String? = null,
    override val minHeight: String? = null,
    override val minWidth: String? = null,
    override val overflow: String? = null,
    override val overflowX: String? = null,
    override val overflowY: String? = null,
    override val pb: Long? = null,
    override val pl: Long? = null,
    override val pr: Long? = null,
    override val pt: Long? = null,
    override val textColorVar: DefnDtoColorData? = null,
    override val width: String? = null
) : FieldDtoSectionLayout
