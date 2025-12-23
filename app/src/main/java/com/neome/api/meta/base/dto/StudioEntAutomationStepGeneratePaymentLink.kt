// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam

open class StudioEntAutomationStepGeneratePaymentLink : StudioEntAutomationStep() {
    var allowedPaymentMethodSet: Array<EnumDefnPaymentMethodKind>? = null
    var amountValue: StudioBuildArgBinder? = null
    var currencyValue: StudioBuildArgBinder? = null
    var descriptionValue: StudioBuildArgBinder? = null
    var expiryDurationValue: StudioBuildArgBinder? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var outputFormPipelineVarId: MetaIdPipelineParam? = null
    var paymentLinkFieldId: MetaIdField? = null
    var referenceIdFieldId: MetaIdField? = null
    var spreadsheetRowIdFieldId: MetaIdField? = null
}
