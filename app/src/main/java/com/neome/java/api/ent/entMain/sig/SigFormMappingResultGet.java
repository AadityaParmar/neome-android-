// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.sig;

import com.neome.java.api.meta.base.Types.MetaIdField;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.dto.FormValue;
import com.neome.java.api.nucleus.base.sig.Sig;

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
