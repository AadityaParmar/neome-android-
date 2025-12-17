// neome.ai API - do not change
//

package com.neome.api.ent.entMain.sig;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.dto.FormValue;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class SigFormMappingResultGet extends Sig
{
  public MetaIdForm formId;

  public FormValue formValue;

  @Nullable
  public Set<MetaIdField> outputFieldIdSet;
}
