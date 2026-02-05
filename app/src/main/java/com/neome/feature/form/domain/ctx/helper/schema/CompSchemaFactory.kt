package com.neome.feature.form.domain.ctx.helper.schema

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData

/**
 * Factory that creates appropriate CompSchema based on component type.
 *
 * Routes each [EnumDefnCompType] to its corresponding CompSchema implementation.
 * Returns null for composite types (section, tab, etc.) and display-only
 * fields that don't require validation.
 */
object CompSchemaFactory {

    fun buildFormSchemas(defnForm: DefnFormData): Map<MetaIdComp, CompSchema> {
        return defnForm.compMap
            .mapNotNull { (fieldId, defnComp) ->
                val schema = this.create(defnForm, defnComp)
                schema?.let { fieldId to it }
            }
            .toMap()
    }

    /**
     * Creates a CompSchema for the given component definition.
     *
     * @param defnComp The component definition to create schema for
     * @return CompSchema for validation, or null for composite/display-only types
     */
    private fun create(defnForm: DefnFormData, defnComp: DefnCompSeal): CompSchema? {
        return when (defnComp.type) {
            // ═══════════════════════════════════════════════════════════════
            // TEXT-BASED FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.text -> FieldTextSchema(defnForm, defnComp)
            EnumDefnCompType.paragraph,
            EnumDefnCompType.handle,
            EnumDefnCompType.hyperlink -> null

            // ═══════════════════════════════════════════════════════════════
            // EMAIL FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.email -> null // TODO: EmailCompSchema

            // ═══════════════════════════════════════════════════════════════
            // NUMBER FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.number,
            EnumDefnCompType.logNumber -> FieldNumberSchema(defnForm, defnComp) // TODO: NumberCompSchema

            // ═══════════════════════════════════════════════════════════════
            // DECIMAL FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.decimal,
            EnumDefnCompType.logDecimal -> null // TODO: DecimalCompSchema

            // ═══════════════════════════════════════════════════════════════
            // DATE/TIME FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.date -> null // TODO: DateCompSchema
            EnumDefnCompType.dateTime -> null // TODO: DateTimeCompSchema
            EnumDefnCompType.time -> null // TODO: TimeCompSchema
            EnumDefnCompType.dateRange -> null // TODO: DateRangeCompSchema
            EnumDefnCompType.dateTimeRange -> null // TODO: DateTimeRangeCompSchema

            // ═══════════════════════════════════════════════════════════════
            // BOOLEAN FIELD
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.bool -> null // TODO: BoolCompSchema

            // ═══════════════════════════════════════════════════════════════
            // PICK/SELECTION FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.pickText -> null // TODO: PickTextCompSchema
            EnumDefnCompType.pickUser -> null // TODO: PickUserCompSchema
            EnumDefnCompType.pickRole -> null // TODO: PickRoleCompSchema
            EnumDefnCompType.pickTree -> null // TODO: PickTreeCompSchema
            EnumDefnCompType.pickGridRow -> null // TODO: PickGridRowCompSchema
            EnumDefnCompType.pickReportRow -> null // TODO: PickReportRowCompSchema

            // ═══════════════════════════════════════════════════════════════
            // SET FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.setOfText -> null // TODO: SetOfTextCompSchema
            EnumDefnCompType.setOfUser -> null // TODO: SetOfUserCompSchema
            EnumDefnCompType.setOfRole -> null // TODO: SetOfRoleCompSchema
            EnumDefnCompType.setOfDocument -> null // TODO: SetOfDocumentCompSchema

            // ═══════════════════════════════════════════════════════════════
            // MEDIA FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.image -> null // TODO: ImageCompSchema
            EnumDefnCompType.document -> null // TODO: DocumentCompSchema
            EnumDefnCompType.camera -> null // TODO: CameraCompSchema
            EnumDefnCompType.video -> null // TODO: VideoCompSchema
            EnumDefnCompType.audio -> null // TODO: AudioCompSchema
            EnumDefnCompType.voice -> null // TODO: VoiceCompSchema
            EnumDefnCompType.signature -> null // TODO: SignatureCompSchema

            // ═══════════════════════════════════════════════════════════════
            // SPECIAL TEXT FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.mobileNumber -> null // TODO: MobileNumberCompSchema
            EnumDefnCompType.password -> null // TODO: PasswordCompSchema

            // ═══════════════════════════════════════════════════════════════
            // NUMERIC DISPLAY FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.counter,
            EnumDefnCompType.logCounter -> null // TODO: CounterCompSchema
            EnumDefnCompType.rating -> null // TODO: RatingCompSchema
            EnumDefnCompType.slider -> null // TODO: SliderCompSchema
            EnumDefnCompType.duration -> null // TODO: DurationCompSchema

            // ═══════════════════════════════════════════════════════════════
            // LOCATION FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.location -> null // TODO: LocationCompSchema
            EnumDefnCompType.geoPoint -> null // TODO: GeoPointCompSchema

            // ═══════════════════════════════════════════════════════════════
            // REFERENCE FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.ref -> null // TODO: RefCompSchema
            EnumDefnCompType.refSet -> null // TODO: RefSetCompSchema
            EnumDefnCompType.refUser -> null // TODO: RefUserCompSchema
            EnumDefnCompType.refReport -> null // TODO: RefReportCompSchema
            EnumDefnCompType.refTarget -> null // TODO: RefTargetCompSchema
            EnumDefnCompType.refContact -> null // TODO: RefContactCompSchema

            // ═══════════════════════════════════════════════════════════════
            // CHIPSET FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.chipSet,
            EnumDefnCompType.chipSetDate,
            EnumDefnCompType.chipSetDateTime,
            EnumDefnCompType.chipSetDay,
            EnumDefnCompType.chipSetTime,
            EnumDefnCompType.chipSetDeviceSize,
            EnumDefnCompType.chipSetDeviceType -> null // TODO: ChipSetCompSchema

            // ═══════════════════════════════════════════════════════════════
            // OTHER SPECIALIZED FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.currency -> null // TODO: CurrencyCompSchema
            EnumDefnCompType.color -> null // TODO: ColorCompSchema
            EnumDefnCompType.icon -> null // TODO: IconCompSchema
            EnumDefnCompType.language -> null // TODO: LanguageCompSchema
            EnumDefnCompType.timeZone -> null // TODO: TimeZoneCompSchema
            EnumDefnCompType.month -> null // TODO: MonthCompSchema
            EnumDefnCompType.quarter -> null // TODO: QuarterCompSchema
            EnumDefnCompType.pinShape -> null // TODO: PinShapeCompSchema
            EnumDefnCompType.lineStroke -> null // TODO: LineStrokeCompSchema
            EnumDefnCompType.textSize -> null // TODO: TextSizeCompSchema
            EnumDefnCompType.paymentStatus -> null // TODO: PaymentStatusCompSchema
            EnumDefnCompType.messageKind -> null // TODO: MessageKindCompSchema

            // ═══════════════════════════════════════════════════════════════
            // DISPLAY-ONLY FIELDS (no validation needed)
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.label,
            EnumDefnCompType.divider,
            EnumDefnCompType.html,
            EnumDefnCompType.info,
            EnumDefnCompType.error,
            EnumDefnCompType.button,
            EnumDefnCompType.showCode,
            EnumDefnCompType.scanCode,
            EnumDefnCompType.identifier,
            EnumDefnCompType.dynamic,
            EnumDefnCompType.hyperlinkRow,
            EnumDefnCompType.propertyMap -> null

            // ═══════════════════════════════════════════════════════════════
            // COMPOSITE TYPES (no FieldState, no validation)
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.section,
            EnumDefnCompType.tab,
            EnumDefnCompType.grid,
            EnumDefnCompType.wizard,
            EnumDefnCompType.spreadsheetRef -> null

            // ═══════════════════════════════════════════════════════════════
            // ID FIELDS
            // ═══════════════════════════════════════════════════════════════
            EnumDefnCompType.rowId,
            EnumDefnCompType.symbol,
            EnumDefnCompType.schedulerId,
            EnumDefnCompType.spreadsheetId,
            EnumDefnCompType.userId -> null // TODO: IdCompSchema if needed

            // ═══════════════════════════════════════════════════════════════
            // ALL OTHER TYPES (enum*, studio*, pick*, etc.)
            // ═══════════════════════════════════════════════════════════════
            else -> null
        }
    }
}
