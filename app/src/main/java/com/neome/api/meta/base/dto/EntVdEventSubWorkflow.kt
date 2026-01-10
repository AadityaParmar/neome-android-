// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineVar

interface EntVdEventSubWorkflow : EntVdEvent {
    val inputForm: FormRefKey?
    val outputForm: FormRefKey?
    val sharedParameterSet: List<MetaIdPipelineVar>?
    val workflowPointer: EntVdWorkflowPointer?
}
