package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnGrid
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutGridMapData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfActionPermissionData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.RowIdSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DefnGridSeal : DefnGrid


@Serializable
data class DefnGridData(
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
    override val hideAddBtn: Boolean? = null,
    override val isPickMany: Boolean? = null,
    override val layoutGridMap: DefnLayoutGridMapData? = null,
    override val maxRows: Long? = null,
    override val maxRowsVar: Long? = null,
    @Serializable(with = MetaIdGridSer::class) override val metaId: Types.MetaIdGrid,
    override val minRows: Long? = null,
    override val minRowsVar: Long? = null,
    override val pickedRowIdSet: List<@Serializable(with = RowIdSer::class) Types.RowId>? = null,
    override val propertyEditorLabel: String? = null,
    override val rowActionPermissionMap: DefnStudioMapOfActionPermissionData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val showAllRowsFieldId: Types.MetaIdField? = null,
    override val showExpand: Boolean? = null
) : DefnCompSeal, DefnGrid
