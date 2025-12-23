// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import com.neome.api.meta.base.Types.DemoAppId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.Sig

open class SigDemoApp : Sig() {
    lateinit var app: Object
    lateinit var demoAppId: DemoAppId
    lateinit var entId: EntId
}
