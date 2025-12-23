// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MediaId
import com.neome.api.nucleus.base.msg.Msg

open class MsgPdfMerge : Msg() {
    var fileName: String? = null
    lateinit var pdfMediaIdSet: Array<MediaId>
}
