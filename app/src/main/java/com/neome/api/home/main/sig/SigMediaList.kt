// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.sig.Sig

class SigMediaList : Sig() {
    val documentList: SigMessageBase[]
    val linkList: SigMessageBase[]
    val mediaCount: number
    val mediaList: SigMessageBase[]
}
