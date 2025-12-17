// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdLayoutFormEditorComposite;
import com.neome.api.meta.base.dto.StudioBase;
import com.neome.api.meta.base.dto.StudioDtoLayoutFormEditorComposite;

@SuppressWarnings("unused")
public class StudioMapOfLayoutFormEditorComposite extends StudioBase
{
  public MetaIdLayoutFormEditorComposite[] keys;

  public Map<MetaIdLayoutFormEditorComposite, StudioDtoLayoutFormEditorComposite> map;
}
