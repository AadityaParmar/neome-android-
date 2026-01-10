package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioFieldRefReport
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoLayoutOverlaySpreadsheetData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPermissionMatrixData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFieldRefReportData(
    override val aiInstructions: String? = null,
    override val details: StudioDetailsData,
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val disabledVarId: Types.MetaIdVar? = null,
    override val permissionMatrix: StudioDtoPermissionMatrixData? = null,
    override val type: EnumStudioCompType? = null,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val copyFieldMap: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, @Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val editableFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val forceOpenOnFormCreate: Boolean? = null,
    override val forceOpenOnGridRowCreate: Boolean? = null,
    @Serializable(with = MetaIdGridSer::class) override val gridId: Types.MetaIdGrid? = null,
    override val keyFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val layoutGridId: Types.MetaIdLayoutGrid? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val mobileLayoutGridId: Types.MetaIdLayoutGrid? = null,
    override val mobileOverlayLayoutGrid: StudioDtoLayoutOverlaySpreadsheetData? = null,
    override val overlayLayoutGrid: StudioDtoLayoutOverlaySpreadsheetData? = null,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport? = null
) : StudioFieldRefReport
