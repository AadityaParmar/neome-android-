// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.sig.SigVersion

class SigSpreadsheetRowCommentCount : SigVersion() {
    var commentCount: number? = null
    var unreadCommentCount: number? = null
}
