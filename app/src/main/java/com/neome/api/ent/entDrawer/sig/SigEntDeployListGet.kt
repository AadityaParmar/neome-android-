// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.sig

import com.neome.api.ent.base.dto.DtoEntDeploy
import com.neome.api.meta.base.Types.EntId
import java.util.Map
import com.neome.api.nucleus.base.sig.Sig

open class SigEntDeployListGet : Sig()
{
  lateinit var entMap: Map<EntId, DtoEntDeploy>
}