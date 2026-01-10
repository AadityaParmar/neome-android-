package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.StudioBuildDate
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioFieldDate
import com.neome.api.meta.base.dto.StudioFieldDateRange
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildDateData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFieldDateRangeData(
    override val aiInstructions: String? = null,
    override val details: StudioDetailsData,
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val disabledVarId: Types.MetaIdVar? = null,
    override val permissionMatrix: StudioDtoPermissionMatrixData? = null,
    override val type: EnumStudioCompType? = null,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val autoFill: Boolean? = null,
    override val autoFocus: Boolean? = null,
    override val helperText: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val helperTextFieldId: Types.MetaIdField? = null,
    override val helperTextVarId: StudioValueVarIdTextData? = null,
    override val hideLabel: Boolean? = null,
    override val icon: String? = null,
    @Serializable(with = MetaIdVarSer::class) override val iconVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val placeHolder: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val placeHolderFieldId: Types.MetaIdField? = null,
    override val placeHolderVarId: StudioValueVarIdTextData? = null,
    override val prefix: String? = null,
    override val prefixVarId: StudioValueVarIdTextData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val refFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdSer::class) override val refTargetId: Types.MetaId? = null,
    override val required: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val requiredFieldId: Types.MetaIdField? = null,
    override val requiredRoleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val requiredVarId: Types.MetaIdVar? = null,
    override val suffix: String? = null,
    override val suffixVarId: StudioValueVarIdTextData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val defaultFieldId: Types.MetaIdField? = null,
    override val defaultValue: StudioBuildDateData? = null,
    @Serializable(with = MetaIdVarSer::class) override val defaultVarId: Types.MetaIdVar? = null,
    override val displayDateFormat: String? = null,
    override val max: StudioBuildDateData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val maxFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val maxVarId: Types.MetaIdVar? = null,
    override val min: StudioBuildDateData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val minFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val minVarId: Types.MetaIdVar? = null,
    override val fromDefault: StudioBuildDateData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fromDefaultFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val fromDefaultVarId: Types.MetaIdVar? = null,
    override val toDefault: StudioBuildDateData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val toDefaultFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val toDefaultVarId: Types.MetaIdVar? = null
) : StudioFieldDateRange
