// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

open class MsgNeoQLResult : Msg() {
    var inputFormCompositeId: MetaIdComposite? = null
    var inputFormId: MetaIdForm? = null
    var inputFormValue: FormValueRaw? = null
    var inputGridRowId: RowId? = null
    lateinit var neoQL: String
    lateinit var outputFormId: MetaIdForm
    lateinit var userHandle: String
}
