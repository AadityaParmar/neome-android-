// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId
import java.util.Date
import com.neome.api.meta.base.Types.SnapshotId
import com.neome.api.meta.base.dto.StudioBase

open class SnapshotAvatar : StudioBase()
{
  lateinit var createdBy: AdminId
  lateinit var createdByName: String
  lateinit var dateTime: String
  lateinit var entVersion: String
  lateinit var name: String
  var parentSnapshotId: SnapshotId? = null
  lateinit var snapshotId: SnapshotId
}