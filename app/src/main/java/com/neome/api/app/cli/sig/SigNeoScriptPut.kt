// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.cli.sig

import com.neome.api.meta.base.Types.ArtifactId
import com.neome.api.meta.base.dto.DtoLogItemList
import com.neome.api.nucleus.base.sig.Sig

interface SigNeoScriptPut : Sig
{
  val appendItemList: DtoLogItemList?
  val cliCodeId: String?
  val lastArtifactName: String?
  val lastDeployUnitId: ArtifactId?
}