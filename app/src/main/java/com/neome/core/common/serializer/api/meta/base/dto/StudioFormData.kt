package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioCompositeMap
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.api.meta.base.dto.StudioForm
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.api.meta.base.dto.StudioMapOfFormula
import com.neome.api.meta.base.dto.StudioMapOfLayoutForm
import com.neome.api.meta.base.dto.StudioPaymentConfig
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.api.meta.base.dto.StudioVisibilityRuleMap
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFormData(
    override val actionPermissionMap: StudioMapOfActionPermission? = null,
    override val aiInstructions: String? = null,
    override val allowToPrintForm: Boolean? = null,
    override val calculateFormulaMode: EnumDefnCalculateFormulaMode? = null,
    override val chatBubbleFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val chatLabelFieldId: Types.MetaIdField? = null,
    override val chatLabelPatternVarId: StudioValueVarIdText? = null,
    override val chatPatternVarId: StudioValueVarIdParagraph? = null,
    override val commentReadOnlyRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val commentRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val compositeMap: StudioCompositeMap,
    override val configForm: Boolean? = null,
    override val details: StudioDetails,
    override val formulaMap: StudioMapOfFormula? = null,
    override val layoutMap: StudioMapOfLayoutForm? = null,
    @Serializable(with = MetaIdFormSer::class) override val metaId: Types.MetaIdForm,
    override val payment: StudioPaymentConfig? = null,
    override val permissionMatrix: StudioDtoPermissionMatrix? = null,
    override val tabVariant: EnumDefnThemeTabVariant? = null,
    override val visibilityRuleMap: StudioVisibilityRuleMap? = null
) : StudioForm
