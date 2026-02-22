# screen — Form Screen

## Purpose

Provides the standalone `FormScreen` composable and its `FormScreenViewModel` — the host screen implementation that embeds the `Form` component. This screen is primarily used for development/demo purposes: it loads a sample form definition from `FormSampleDataFactory`, renders it inside a `Scaffold`, logs received `FormIntent`s, and exposes a submit button via `FormRef`.

## Responsibilities

- `FormScreen` — `@Composable` host screen: collects `intentLog` from the ViewModel, creates a `formRefState: MutableState<FormRef?>`, renders `Form(...)` with `viewModel.defnForm`, and shows the last 3 intent log entries + a Submit button below the form
- `FormScreenViewModel` — `@HiltViewModel`: holds `defnForm: DefnFormUi` (loaded synchronously from `FormSampleDataFactory.createTextForm()` on construction), receives `FormIntent` via `onFormIntent`, logs intent messages to `_intentLog: MutableStateFlow<List<String>>` (capped at 5), and exposes `intentLog: StateFlow<List<String>>`

## Flow

1. **ViewModel init** — `FormScreenViewModel` is constructed by Hilt; `defnForm` is initialized immediately by calling `FormSampleDataFactory.createTextForm()`.
2. **Screen composition** — `FormScreen` calls `hiltViewModel()` to get `FormScreenViewModel`, collects `intentLog` via `collectAsStateWithLifecycle()`.
3. **FormRef setup** — `remember { mutableStateOf<FormRef?>(null) }` creates the ref holder. `Form` writes to it via `LaunchedEffect` and clears it on dispose.
4. **Form rendering** — `Form(defnForm = viewModel.defnForm, formRef = formRefState, onIntent = viewModel::onFormIntent)` renders the form content with `Modifier.weight(1f)`.
5. **Intent logging** — Every `FormIntent` (Submit, Watch, ValidationStateChanged, SendBtnStateChanged) received by `onFormIntent` is formatted to a string and appended to `_intentLog`. Only the last 5 messages are kept.
6. **Submit button** — Button at the bottom of the screen calls `formRefState.value?.submit()` to trigger form validation and submission via `FormRef`.

## Key Entry Points

| File | Symbol | Role |
|------|--------|------|
| `FormScreen.kt` | `FormScreen` | `@Composable` host screen; params: `modifier: Modifier`, `viewModel: FormScreenViewModel` (hiltViewModel default) |
| `FormScreenViewModel.kt` | `FormScreenViewModel` | `@HiltViewModel class` — `defnForm: DefnFormUi`, `intentLog: StateFlow<List<String>>`, `onFormIntent(intent: FormIntent)` |
| `FormScreenViewModel.kt` | `FormScreenViewModel.defnForm` | `val` property — `DefnFormUi` initialized from `FormSampleDataFactory.createTextForm()` |
| `FormScreenViewModel.kt` | `FormScreenViewModel.onFormIntent` | Public method — formats `FormIntent` to log string, appends to `intentLog` |

## Dependencies

- `androidx.hilt.navigation.compose.hiltViewModel` — ViewModel injection in composable
- `androidx.lifecycle.compose.collectAsStateWithLifecycle` — lifecycle-aware state collection
- `com.neome.feature.form.domain.ref.FormRef` — type of `formRefState.value`; `submit()` called on button click
- `com.neome.feature.form.presentation.components.Form` — embedded form component
- `com.neome.feature.form.presentation.sample.FormSampleDataFactory` — provides sample `DefnFormUi`
- `com.neome.feature.form.presentation.state.FormIntent` — received by ViewModel; all variants logged
- `dagger.hilt.android.lifecycle.HiltViewModel` + `javax.inject.Inject` — Hilt ViewModel injection
- `kotlinx.coroutines.flow.MutableStateFlow` / `asStateFlow` — intent log state

## Related READMEs

- **Parent**: `../README.md` (presentation layer root)
- **Form component**: `../components/README.md` (Form.kt — what FormScreen embeds)
- **Sample data**: `../sample/README.md` (FormSampleDataFactory — provides defnForm)
- **State types**: `../state/README.md` (FormIntent variants logged by ViewModel)
- **FormRef**: `../../domain/ref/README.md` (FormRef.submit() called by submit button)
- **Form root**: `../../form.md` (full form feature documentation)

## Change Notes

- Initial documentation created from source analysis (2026-02-22)
- 2 source files: `FormScreen.kt`, `FormScreenViewModel.kt`
- This screen is a development/demo host — not intended as a production navigation destination
- `intentLog` is capped at 5 entries in the ViewModel but only the last 3 are shown in the UI (`takeLast(3)`)
- `FormScreenViewModel.onFormIntent` uses `android.util.Log.d("FormScreen", message)` for debug logging in addition to updating state
- Submit button is disabled when `formRefState.value == null` (before `Form` sets the ref via `LaunchedEffect`)
