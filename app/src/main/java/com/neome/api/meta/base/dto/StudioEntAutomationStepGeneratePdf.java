// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepGeneratePdf extends StudioEntAutomationStepGenerateDocument
{
  @Nullable
  public MetaIdField pdfFieldId;

  @Nullable
  public MetaIdForm pdfFormId;

  @Nullable
  public MetaIdVar pdfFormMappingVarId;
}
