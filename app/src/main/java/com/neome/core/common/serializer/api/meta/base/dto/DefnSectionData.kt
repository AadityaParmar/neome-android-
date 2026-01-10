package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnSection
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.api.meta.base.dto.FieldDtoSectionLayout
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfActionPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoSectionLayoutData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSectionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnSectionSeal : DefnSection


@Serializable
data class DefnSectionData(
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val disabledVar: Boolean? = null,
    override val hidden: Boolean? = null,
    override val hideDirtyIndicator: Boolean? = null,
    override val invisible: Boolean? = null,
    override val label: String? = null,
    override val maxWidth: Long? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pb: Long? = null,
    override val permissionMatrix: DefnDtoPermissionMatrixData? = null,
    override val pl: Long? = null,
    override val pr: Long? = null,
    override val pt: Long? = null,
    override val readOnly: Boolean? = null,
    override val type: EnumDefnCompType,
    override val actionPermissionMap: DefnStudioMapOfActionPermissionData? = null,
    override val fieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val fieldSpanMap: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, Long>? = null,
    override val flexGrow: Boolean? = null,
    override val justifyContent: EnumDefnPlacement? = null,
    @Serializable(with = MetaIdSectionSer::class) override val metaId: Types.MetaIdSection,
    override val overflowHidden: Boolean? = null,
    override val propertyEditorLabel: String? = null,
    override val reportLayout: FieldDtoSectionLayoutData? = null,
    override val sectionDirection: EnumDefnThemeDirection? = null,
    override val sectionVariant: EnumDefnThemeSectionVariant? = null
) : DefnCompSeal, DefnSection
