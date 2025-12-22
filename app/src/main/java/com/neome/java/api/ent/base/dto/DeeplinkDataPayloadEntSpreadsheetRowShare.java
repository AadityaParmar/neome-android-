// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.home.main.sig.SigSpreadsheetRow;
import com.neome.java.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.java.api.meta.base.dto.DefnForm;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DeeplinkDataPayloadEntSpreadsheetRowShare extends DeeplinkDataPayloadEnt
{
  @Nullable
  public DefnForm defnForm;

  @Nullable
  public MetaIdLayoutForm formContentLayoutId;

  @Nullable
  public MetaIdLayoutForm formTemplateLayoutId;

  @Nullable
  public Boolean isPublicUpdateAllowed;

  @Nullable
  public SigSpreadsheetRow spreadsheetRow;
}
