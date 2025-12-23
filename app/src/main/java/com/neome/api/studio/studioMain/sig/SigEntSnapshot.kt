// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.studio.base.dto.SnapshotItem

open class SigEntSnapshot : SigVersion()
{
  lateinit var snapshotItem: SnapshotItem
}