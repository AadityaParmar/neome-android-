// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.nucleus.base.sig.Sig
import kotlin.properties.Delegates

open class SigPdfMerge : Sig() {
    lateinit var fileExt: EnumDefnDocFileExt
    var fileLength: Number by Delegates.notNull<Number>()
    lateinit var fileName: String
    lateinit var mediaId: MediaId
}
