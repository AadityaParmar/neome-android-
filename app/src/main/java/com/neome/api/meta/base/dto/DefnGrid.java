// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdGrid;
import com.neome.api.meta.base.Types.RowId;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnGrid extends DefnComp
{
  @Nullable
  public DefnStudioMapOfActionPermission actionPermissionMap;

  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public Boolean hideAddBtn;

  @Nullable
  public Boolean isPickMany;

  @Nullable
  public DefnLayoutGridMap layoutGridMap;

  @Nullable
  public Long maxRows;

  @Nullable
  public Long maxRowsVar;

  public MetaIdGrid metaId;

  @Nullable
  public Long minRows;

  @Nullable
  public Long minRowsVar;

  @Nullable
  public RowId[] pickedRowIdSet;

  @Nullable
  public String propertyEditorLabel;

  @Nullable
  public DefnStudioMapOfActionPermission rowActionPermissionMap;

  @Nullable
  public MetaIdField showAllRowsFieldId;

  @Nullable
  public Boolean showExpand;
}
