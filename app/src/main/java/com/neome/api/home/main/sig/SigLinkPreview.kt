// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.nucleus.base.sig.Sig

interface SigLinkPreview : Sig
{
  val description: String?
  val imageUrl: String?
  val title: String
}