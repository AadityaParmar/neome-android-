// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.nucleus.base.msg.Msg

open class MsgSpreadsheetPartitionSend : Msg() {
    lateinit var actionId: MetaIdAction
    lateinit var formId: MetaIdForm
    lateinit var toGroupId: GroupId
}
