// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.EnumDefnKindImport;
import com.neome.java.api.meta.base.Types.MetaIdPlugin;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntImport extends StudioBase
{
  @Nullable
  public String description;

  @Nullable
  public EnumDefnKindImport kind;

  public MetaIdPlugin metaId;

  @Nullable
  public StudioModuleSelection modules;

  @Nullable
  public Symbol name;
}
