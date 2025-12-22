// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.AdminId;
import com.neome.java.api.meta.base.Types.EnumDefnKindNoteStatus;
import com.neome.java.api.meta.base.Types.EnumDefnTextSize;
import com.neome.java.api.meta.base.Types.MetaIdVdNote;
import com.neome.java.api.meta.base.Types.MetaIdVdRegion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdNote extends EntVdRect
{
  @Nullable
  public AdminId adminId;

  public MetaIdVdNote metaId;

  @Nullable
  public MetaIdVdRegion parentRegionId;

  @Nullable
  public EnumDefnKindNoteStatus status;

  @Nullable
  public EnumDefnTextSize textSize;

  @Nullable
  public String value;
}
