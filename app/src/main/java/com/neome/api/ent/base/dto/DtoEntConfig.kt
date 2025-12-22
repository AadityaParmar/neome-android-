// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnEntStage

class DtoEntConfig {
    var allowClearSpreadsheet: boolean? = null
    var confirmBeforeDelete: boolean? = null
    var hideObsoleteFeatures: boolean? = null
    var lockEnterprise: boolean? = null
    var showCompletedWorkflows: boolean? = null
    var stage: EnumDefnEntStage? = null
}
