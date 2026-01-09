package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioFieldCounter
import com.neome.api.meta.base.dto.StudioFieldSlider
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFieldSliderData(
    override val aiInstructions: String? = null,
    override val details: StudioDetails,
    override val disabled: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val disabledFieldId: Types.MetaIdField? = null,
    override val disabledRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val disabledVarId: Types.MetaIdVar? = null,
    override val permissionMatrix: StudioDtoPermissionMatrix? = null,
    override val type: EnumStudioCompType? = null,
    @Serializable(with = MetaIdFieldSer::class) override val metaId: Types.MetaIdField,
    override val autoFill: Boolean? = null,
    override val autoFocus: Boolean? = null,
    override val helperText: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val helperTextFieldId: Types.MetaIdField? = null,
    override val helperTextVarId: StudioValueVarIdText? = null,
    override val hideLabel: Boolean? = null,
    override val icon: String? = null,
    @Serializable(with = MetaIdVarSer::class) override val iconVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val labelFieldId: Types.MetaIdField? = null,
    override val placeHolder: String? = null,
    @Serializable(with = MetaIdFieldSer::class) override val placeHolderFieldId: Types.MetaIdField? = null,
    override val placeHolderVarId: StudioValueVarIdText? = null,
    override val prefix: String? = null,
    override val prefixVarId: StudioValueVarIdText? = null,
    @Serializable(with = MetaIdFieldSer::class) override val refFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdSer::class) override val refTargetId: Types.MetaId? = null,
    override val required: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val requiredFieldId: Types.MetaIdField? = null,
    override val requiredRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdVarSer::class) override val requiredVarId: Types.MetaIdVar? = null,
    override val suffix: String? = null,
    override val suffixVarId: StudioValueVarIdText? = null,
    @Serializable(with = MetaIdFieldSer::class) override val defaultFieldId: Types.MetaIdField? = null,
    override val defaultValue: Long? = null,
    @Serializable(with = MetaIdVarSer::class) override val defaultVarId: Types.MetaIdVar? = null,
    override val max: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val maxFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val maxVarId: Types.MetaIdVar? = null,
    override val min: Long? = null,
    override val minDisplayValue: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val minFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val minVarId: Types.MetaIdVar? = null,
    override val step: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val stepFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val stepVarId: Types.MetaIdVar? = null,
    override val allowRangePicker: Boolean? = null,
    override val showAsInputBox: Boolean? = null
) : StudioFieldSlider
