// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnRenderingKind;
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind;
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutFormTemplate extends StudioDtoLayoutForm
{
  @Nullable
  public EnumDefnShowBorderKind[] borderPositionSet;

  @Nullable
  public StudioDtoLayoutFormFooter footer;

  @Nullable
  public StudioDtoLayoutFormHeader header;

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
  public StudioDtoLayoutFormWatermark watermark;
}
