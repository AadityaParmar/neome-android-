// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdLayoutDriveSheet;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoLayoutDriveSheet;

@SuppressWarnings("unused")
public class StudioMapOfLayoutDriveSheet extends StudioBase
{
  @Nullable
  public MetaIdField[] includeMetaFieldIdSet;

  public MetaIdLayoutDriveSheet[] keys;

  public Map<MetaIdLayoutDriveSheet, StudioDtoLayoutDriveSheet> map;
}
