// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.nucleus.base.sig.Sig

class SigPdfMerge : Sig() {
    val fileExt: EnumDefnDocFileExt
    val fileLength: number
    val fileName: string
    val mediaId: MediaId
}
