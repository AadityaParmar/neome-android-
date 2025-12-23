# File Picker Feature

## Feature Objective

- Build a reusable File Picker feature
- Platform: Android – Jetpack Compose (Kotlin)
- Allow selecting files using system pickers
- Return structured metadata for the selected file

---

## Architecture Rules

- Follow `CLAUDE.md` strictly
- Follow `architecture_guide.md` strictly
- All implementation code must reside under: `feature/filepick/`
- Do not redefine architecture patterns already in `CLAUDE.md` or `architecture_guide.md`
- Do not introduce new architectural patterns

---

## Functional Requirements

### Supported Picker Modes

- Pick Image (single image)
- Pick Video (single video)
- Pick Image + Video (single selection)
- Pick PDF (single document)
- Pick All Files (any type)

### Behavior

- Use Android system file pickers only
- Default to single-file selection
- Handle user cancellation silently and safely
- Do not add backward-compatibility layers beyond project configuration

---

## Output Contract

Return a data model containing:

- File name
- File size (bytes)
- MIME type
- File URI (content URI)

---

## Explicit Exclusions

- No file copying
- No file persistence or caching
- No preview (image/video)
- No cropping or editing
- No reading file content

---

## Component Showcase Requirements

### Demo Entries

Add demos in Component Showcase for:

- Pick Image
- Pick Video
- Pick Image + Video
- Pick PDF
- Pick All Files

### Showcase Rules

- Must consume implementation from `feature/filepick/`
- Must NOT contain picker logic
- Must NOT directly use Activity Result APIs
- Must display returned metadata:
  - File name
  - File size (formatted)
  - MIME type
  - URI string
- Show empty/default state when no file is selected
- Handle cancellation without errors or messages

---

## Technical Constraints

- Use modern Android system file picking APIs (SAF-based)
- Avoid deprecated APIs
- Avoid third-party libraries
- Avoid unnecessary abstractions

---

## Output Rules (For Implementing Agent)

- Provide code only
- No explanations unless explicitly requested
- Ask one clarification question only if required for correctness
- Assume stateless execution
- Ensure code is syntactically correct and logically consistent
