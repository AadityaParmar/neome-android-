// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnEntStage

open class DtoEntConfig {
    var allowClearSpreadsheet: Boolean? = null
    var confirmBeforeDelete: Boolean? = null
    var hideObsoleteFeatures: Boolean? = null
    var lockEnterprise: Boolean? = null
    var showCompletedWorkflows: Boolean? = null
    var stage: EnumDefnEntStage? = null
}
