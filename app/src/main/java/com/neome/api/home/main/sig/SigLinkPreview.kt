// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.sig.Sig

open class SigLinkPreview : Sig()
{
  var description: String? = null
  var imageUrl: String? = null
  lateinit var title: String
}