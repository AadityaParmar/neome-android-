package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.base.dto.DtoPickerEntUser
import com.neome.api.ent.entAside.sig.SigEntUserPickerCandidateListGet
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoPickerEntUserData
import kotlinx.serialization.Serializable


@Serializable
data class SigEntUserPickerCandidateListGetData(
    override val candidateList: List<DtoPickerEntUserData>
) : SigEntUserPickerCandidateListGet
