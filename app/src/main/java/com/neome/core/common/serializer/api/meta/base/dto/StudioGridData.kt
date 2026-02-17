package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.StudioComposite
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioFieldMap
import com.neome.api.meta.base.dto.StudioGrid
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.api.meta.base.dto.StudioMapOfLayoutGrid
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.StudioFieldMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfActionPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfLayoutGridData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioGridData(
    override val aiInstructions: String? = null,
    override val details: StudioDetailsData,
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val disabledVarId: Types.MetaIdVar? = null,
    override val permissionMatrix: StudioDtoPermissionMatrixData? = null,
    override val type: EnumStudioCompType? = null,
    override val actionPermissionMap: StudioMapOfActionPermissionData? = null,
    override val fieldMap: StudioFieldMapData,
    override val layoutGridMap: StudioMapOfLayoutGridData? = null,
    override val maxRows: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val maxRowsFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val maxRowsVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdGridSer::class) override val metaId: Types.MetaIdGrid,
    override val minRows: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val minRowsFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val minRowsVarId: Types.MetaIdVar? = null,
    override val rowActionPermissionMap: StudioMapOfActionPermissionData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val showAllRowsFieldId: Types.MetaIdField? = null
) : StudioGrid
