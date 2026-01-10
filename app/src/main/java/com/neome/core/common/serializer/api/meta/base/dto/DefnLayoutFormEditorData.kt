package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnEditorLayoutRenderingMode
import com.neome.api.meta.base.Types.EnumDefnFormLayoutType
import com.neome.api.meta.base.Types.EnumDefnWizardNavigationMode
import com.neome.api.meta.base.dto.DefnLayoutForm
import com.neome.api.meta.base.dto.DefnLayoutFormEditor
import com.neome.api.meta.base.dto.DefnMapOfLayoutFormEditorComposite
import com.neome.core.common.serializer.api.meta.base.dto.DefnMapOfLayoutFormEditorCompositeData
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormEditorData(
    @Serializable(with = MetaIdLayoutFormSer::class) override val metaId: Types.MetaIdLayoutForm,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val type: EnumDefnFormLayoutType? = null,
    override val allowToSwitchLayoutIdSet: List<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    override val compositeIdSet: List<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite>? = null,
    override val editorLayoutRenderingMode: EnumDefnEditorLayoutRenderingMode? = null,
    override val formEditorLayoutIdSet: List<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>? = null,
    override val hideLabelCompositeIdSet: List<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite>? = null,
    override val label: String? = null,
    override val layoutCompositeMap: DefnMapOfLayoutFormEditorCompositeData? = null,
    override val navigationMode: EnumDefnWizardNavigationMode? = null,
    override val nextButtonLabel: String? = null,
    override val prevButtonLabel: String? = null,
    override val showStepper: Boolean? = null
) : DefnLayoutFormEditor
