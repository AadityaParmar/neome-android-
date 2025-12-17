// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioGrid extends StudioComposite
{
  @Nullable
  public StudioMapOfLayoutGrid layoutGridMap;

  @Nullable
  public Long maxRows;

  @Nullable
  public MetaIdVar maxRowsVarId;

  public MetaIdGrid metaId;

  @Nullable
  public Long minRows;

  @Nullable
  public MetaIdVar minRowsVarId;

  @Nullable
  public StudioMapOfActionPermission rowActionPermissionMap;

  @Nullable
  public MetaIdField showAllRowsFieldId;
}
