// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnThemeDirection;
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdLayoutFormEditorComposite;
import com.neome.api.meta.base.Types.MetaIdLayoutGrid;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioDtoLayoutFormEditorComposite extends StudioBase
{
  public MetaIdComposite compositeId;

  @Nullable
  public MetaIdLayoutGrid gridLayoutId;

  public MetaIdLayoutFormEditorComposite metaId;

  @Nullable
  public EnumDefnThemeDirection sectionDirection;

  @Nullable
  public EnumDefnThemeSectionVariant sectionVariant;
}
