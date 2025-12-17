// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdTab;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnTab extends DefnComp
{
  public MetaIdTab metaId;

  @Nullable
  public Boolean showAsTree;

  @Nullable
  public Boolean showDivider;

  @Nullable
  public Boolean showSingleTab;

  @Nullable
  public MetaIdComposite[] tabIdSet;

  @Nullable
  public EnumDefnThemeTabVariant tabVariant;
}
