// neome.ai API - do not change
//

package com.neome.java.api.ent.entAside.msg;

import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdVar;
import com.neome.java.api.meta.base.dto.FormValueRaw;
import com.neome.java.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgEntUserPickerCandidateListGet extends Msg
{
  @Nullable
  public FormValueRaw formValueRaw;

  @Nullable
  public Set<MetaIdRole> roleIdSet;

  @Nullable
  public MetaIdVar setOfUserVarId;

  public MetaIdForm sourceFormId;
}
