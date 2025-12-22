// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.java.api.meta.base.Types.EnumDefnThemeDividerKind;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnDtoLayoutFormContentItem
{
  @Nullable
  public DefnDtoColor borderColorVar;

  @Nullable
  public EnumDefnShowBorderKind[] borderPositionSet;

  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public MetaIdLayoutForm[] formLayoutIdSet;

  @Nullable
  public MetaIdLayoutGrid[] gridLayoutIdSet;

  @Nullable
  public EnumDefnShowBorderKind[] paddingPositionSet;

  @Nullable
  public EnumDefnThemeDividerKind paddingSize;

  @Nullable
  public MetaIdGrid[] showGridSwitcher;
}
