// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.sig.Sig

interface SigMediaList : Sig {
    val documentList: List<SigMessageBase>
    val linkList: List<SigMessageBase>
    val mediaCount: Long?
    val mediaList: List<SigMessageBase>
}
