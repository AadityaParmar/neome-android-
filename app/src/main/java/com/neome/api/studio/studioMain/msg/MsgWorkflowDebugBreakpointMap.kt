// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.MetaIdVdAutoDia
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.nucleus.base.msg.Msg

class MsgWorkflowDebugBreakpointMap : Msg() {
    val breakpointMap: Record<MetaIdVdAutoDia, MetaIdVdAutoNode[]>
}
