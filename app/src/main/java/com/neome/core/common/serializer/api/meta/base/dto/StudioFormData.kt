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
import com.neome.core.common.serializer.api.meta.base.dto.StudioCompositeMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPermissionMatrixData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfActionPermissionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfFormulaData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfLayoutFormData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPaymentConfigData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import com.neome.core.common.serializer.api.meta.base.dto.StudioVisibilityRuleMapData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFormData(
    override val actionPermissionMap: StudioMapOfActionPermissionData? = null,
    override val aiInstructions: String? = null,
    override val allowToPrintForm: Boolean? = null,
    override val calculateFormulaMode: EnumDefnCalculateFormulaMode? = null,
    override val chatBubbleFieldIdSet: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val chatLabelFieldId: Types.MetaIdField? = null,
    override val chatLabelPatternVarId: StudioValueVarIdTextData? = null,
    override val chatPatternVarId: StudioValueVarIdParagraphData? = null,
    override val commentReadOnlyRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val commentRoleSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val compositeMap: StudioCompositeMapData,
    override val configForm: Boolean? = null,
    override val details: StudioDetailsData,
    override val formulaMap: StudioMapOfFormulaData? = null,
    override val layoutMap: StudioMapOfLayoutFormData? = null,
    @Serializable(with = MetaIdFormSer::class) override val metaId: Types.MetaIdForm,
    override val payment: StudioPaymentConfigData? = null,
    override val permissionMatrix: StudioDtoPermissionMatrixData? = null,
    override val tabVariant: EnumDefnThemeTabVariant? = null,
    override val visibilityRuleMap: StudioVisibilityRuleMapData? = null
) : StudioForm
