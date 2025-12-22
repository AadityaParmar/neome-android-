// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnThemeDirection;
import com.neome.java.api.meta.base.Types.EnumDefnThemeSectionVariant;
import com.neome.java.api.meta.base.Types.MetaIdSection;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioSection extends StudioComposite
{
  @Nullable
  public EnumDefnThemeDirection direction;

  public MetaIdSection metaId;

  @Nullable
  public MetaIdVar propertyEditorLabelVarId;

  @Nullable
  public EnumDefnThemeSectionVariant sectionVariant;
}
