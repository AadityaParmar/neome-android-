// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnKindAutoNode;
import com.neome.java.api.meta.base.Types.MetaIdVdAutoNode;
import com.neome.java.api.meta.base.Types.MetaIdVdRegion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdAutoNode extends VdBase
{
  public EnumDefnKindAutoNode kind;

  @Nullable
  public StudioValueParagraph logMsg;

  public MetaIdVdAutoNode metaId;

  public Symbol name;

  @Nullable
  public MetaIdVdRegion parentRegionId;

  @Nullable
  public Point point;

  @Nullable
  public Size size;
}
