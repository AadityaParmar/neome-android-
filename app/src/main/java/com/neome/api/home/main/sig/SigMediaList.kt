// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.main.sig.SigMessageBase

interface SigMediaList : Sig
{
  val documentList: Array<SigMessageBase>
  val linkList: Array<SigMessageBase>
  val mediaCount: Long?
  val mediaList: Array<SigMessageBase>
}