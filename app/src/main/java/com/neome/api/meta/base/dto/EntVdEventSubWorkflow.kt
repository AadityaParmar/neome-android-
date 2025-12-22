// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineVar

class EntVdEventSubWorkflow : EntVdEvent() {
    var inputForm: FormRefKey? = null
    var outputForm: FormRefKey? = null
    var sharedParameterSet: MetaIdPipelineVar[]? = null
    var workflowPointer: EntVdWorkflowPointer? = null
}
