Time Calculator
===============

Small Compose app to add time entries and compute totals. UI, domain logic, and presentation are separated for testability and reuse.

Install on device
-----------------
download the artifact from GitHub Actions (Actions → Build Debug APK → Artifacts).

Project structure
-----------------
- app/src/main/java/com/example/timecalculator/ui - Compose screens
- app/src/main/java/com/example/timecalculator/domain/model - TimeEntry entity
- app/src/main/java/com/example/timecalculator/domain/usecase - TimeCalculator logic
- app/src/main/java/com/example/timecalculator/presentation - ViewModel and UiState

GitHub Actions
--------------
- .github/workflows/debug-apk.yml builds a debug APK and uploads it as an artifact.

Notes
-----
- Debug APK is signed with the debug key; good for testing only.

