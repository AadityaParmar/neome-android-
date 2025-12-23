// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import kotlin.properties.Delegates
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.main.sig.SigMessageBase

open class SigMediaList : Sig()
{
  lateinit var documentList: Array<SigMessageBase>
  lateinit var linkList: Array<SigMessageBase>
  var mediaCount: Number by Delegates.notNull<Number>()
  lateinit var mediaList: Array<SigMessageBase>
}