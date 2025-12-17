// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnRenderingKind;
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnLayoutFormTemplate extends DefnLayoutForm
{
  @Nullable
  public EnumDefnShowBorderKind[] borderPositionSet;

  @Nullable
  public DefnLayoutFormFooter footer;

  @Nullable
  public DefnLayoutFormHeader header;

  @Nullable
  public EnumDefnShowBorderKind[] paddingPositionSet;

  @Nullable
  public EnumDefnThemeDividerKind paddingSize;

  @Nullable
  public Long paperHeight;

  @Nullable
  public EnumDefnRenderingKind paperSize;

  @Nullable
  public Long paperWidth;

  @Nullable
  public DefnLayoutFormWatermark watermark;
}
