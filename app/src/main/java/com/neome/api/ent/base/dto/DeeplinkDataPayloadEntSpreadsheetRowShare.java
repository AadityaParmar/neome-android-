// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.neome.api.home.main.sig.SigSpreadsheetRow;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.dto.DefnForm;

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
