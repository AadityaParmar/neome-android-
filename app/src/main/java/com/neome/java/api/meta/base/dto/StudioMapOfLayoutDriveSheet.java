// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdLayoutDriveSheet;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioMapOfLayoutDriveSheet extends StudioBase
{
  @Nullable
  public MetaIdField[] includeMetaFieldIdSet;

  public MetaIdLayoutDriveSheet[] keys;

  public Map<MetaIdLayoutDriveSheet, StudioDtoLayoutDriveSheet> map;
}
