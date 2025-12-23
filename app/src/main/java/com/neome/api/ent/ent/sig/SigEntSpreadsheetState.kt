// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import com.neome.api.nucleus.base.sig.Sig

open class SigEntSpreadsheetState : Sig() {
    lateinit var gridRemoveVer: String
    lateinit var gridVer: String
    lateinit var rowCountVer: String
    lateinit var rowOrderVer: String
    lateinit var sheetIdHash: String
}
