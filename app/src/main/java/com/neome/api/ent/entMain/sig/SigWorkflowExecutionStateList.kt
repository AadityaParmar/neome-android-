// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoWorkflowExecutionStateInfo
import com.neome.api.nucleus.base.sig.Sig

class SigWorkflowExecutionStateList : Sig() {
    val list: DtoWorkflowExecutionStateInfo[]
}
