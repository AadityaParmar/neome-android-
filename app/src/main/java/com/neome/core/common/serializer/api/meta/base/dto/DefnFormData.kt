package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCalculateFormulaMode
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoFormTheme
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutFormMap
import com.neome.api.meta.base.dto.DefnPaymentConfig
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.api.meta.base.dto.DefnVisibilityRuleMap
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnFormData(
    override val actionPermissionMap: DefnStudioMapOfActionPermission? = null,
    override val allowToPrintForm: Boolean? = null,
    override val calculateFormulaMode: EnumDefnCalculateFormulaMode? = null,
    override val chatBubbleFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val chatLabelFieldId: Types.MetaIdField? = null,
    override val chatLabelPatternVar: DefnDtoText? = null,
    override val chatPatternVar: DefnDtoParagraph? = null,
    override val commentReadOnlyRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val commentRoleSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val compMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, DefnCompSeal>,
    override val configForm: Boolean? = null,
    @Serializable(with = MetaIdCompositeSer::class) override val displayCompositeId: Types.MetaIdComposite,
    override val formulaFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val gridLookupMap: Map<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid, @Serializable(with = MetaIdGridSer::class) Types.MetaIdGrid>? = null,
    override val label: String? = null,
    override val layoutMap: DefnLayoutFormMap? = null,
    @Serializable(with = MetaIdFormSer::class) override val metaId: Types.MetaIdForm,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val paymentConfig: DefnPaymentConfig? = null,
    override val permissionMatrix: DefnDtoPermissionMatrix? = null,
    override val theme: DefnDtoFormTheme? = null,
    override val visibilityRuleMap: DefnVisibilityRuleMap? = null
) : DefnForm
