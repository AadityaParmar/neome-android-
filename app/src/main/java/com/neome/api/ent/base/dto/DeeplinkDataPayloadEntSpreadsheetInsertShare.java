// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import com.google.gson.JsonElement;
import com.neome.api.meta.base.Types.ChatId;
import com.neome.api.meta.base.Types.EntId;
import com.neome.api.meta.base.Types.EnumDefnTextSize;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdComp;
import com.neome.api.meta.base.Types.MetaIdLayoutForm;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.DefnDtoColor;
import com.neome.api.meta.base.dto.DefnDtoParagraph;
import com.neome.api.meta.base.dto.DefnForm;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class DeeplinkDataPayloadEntSpreadsheetInsertShare extends DeeplinkDataPayloadEnt
{
  @Nullable
  public ChatId chatId;

  public DefnForm defnForm;

  public EntId entId;

  @Nullable
  public MetaIdLayoutForm formEditorLayoutId;

  @Nullable
  public MetaIdAction metaIdAction;

  @Nullable
  public MetaIdLayoutForm mobileFormEditorLayoutId;

  @Nullable
  public String repeatButtonLabel;

  @Nullable
  public Boolean sendMessageToInbox;

  @Nullable
  public Boolean showRepeatButton;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;

  public DefnDtoParagraph successMessage;

  @Nullable
  public DefnDtoColor successMessageBgColor;

  @Nullable
  public EnumDefnTextSize successMessageTextSize;

  @Nullable
  public Map<MetaIdComp, JsonElement> valueMap;
}
