// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.java.api.meta.base.Types.EnumDefnThemeDividerKind;
import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdGrid;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.Types.MetaIdLayoutGrid;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutFormContentItem extends StudioBase
{
  @Nullable
  public MetaIdVar borderColorVarId;

  @Nullable
  public EnumDefnShowBorderKind[] borderPositionSet;

  @Nullable
  public MetaIdField[] fieldIdSet;

  @Nullable
  public MetaIdLayoutForm[] formLayoutIdSet;

  @Nullable
  public MetaIdLayoutGrid[] gridLayoutIdSet;

  @Nullable
  public MetaIdGrid[] gridSwitcherSet;

  @Nullable
  public EnumDefnShowBorderKind[] paddingPositionSet;

  @Nullable
  public EnumDefnThemeDividerKind paddingSize;
}
