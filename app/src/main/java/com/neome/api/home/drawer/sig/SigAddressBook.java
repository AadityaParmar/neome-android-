// neome.ai API - do not change
//

package com.neome.api.home.drawer.sig;

import com.neome.api.nucleus.base.Types.AnyPrefixKey;
import com.neome.api.home.base.dto.DtoUserAddrBookContact;
import com.neome.api.home.base.dto.DtoUserAddrBookOtherContact;

import java.util.Map;

import com.neome.api.nucleus.base.sig.SigVersion;

@SuppressWarnings("unused")
public class SigAddressBook extends SigVersion
{
  public Map<AnyPrefixKey, DtoUserAddrBookContact[]> candidateMap;

  public DtoUserAddrBookOtherContact[] othersList;
}
