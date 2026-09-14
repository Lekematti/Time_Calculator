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

Calculation
-----------
- The app uses integer math: totalMinutes = hours * 60 + minutes.
- Formatting uses integer division and modulo: hours = totalMinutes / 60, minutes = totalMinutes % 60.
- Behavior is exact for whole-minute inputs (no floating-point rounding or "wiggle"). The app only accepts whole minutes (no seconds).

Notes
-----
- Debug APK is signed with the debug key; good for testing only.

