// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import kotlin.properties.Delegates
import com.neome.api.home.main.sig.SigMessage
import com.neome.api.nucleus.base.sig.SigVersion

open class SigAsideSearch : SigVersion()
{
  lateinit var messageList: Array<SigMessage>
  var totalMessageCount: Number by Delegates.notNull<Number>()
}