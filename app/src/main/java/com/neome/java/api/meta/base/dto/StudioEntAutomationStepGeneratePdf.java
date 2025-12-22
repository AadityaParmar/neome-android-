// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdVar;

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
