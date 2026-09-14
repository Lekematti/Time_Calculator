Time Calculator
===============

Small Compose app to add time entries and compute totals. UI, domain logic, and presentation are separated for testability and reuse.

Quick start
-----------
- Build debug APK: ./gradlew -p app assembleDebug
- Build release APK: ./gradlew -p app assembleRelease

Install on device
-----------------
- Via ADB: adb install -r app/build/outputs/apk/debug/app-debug.apk
- Or download the artifact from GitHub Actions (Actions → Build Debug APK → Artifacts).

Project structure
-----------------
- app/src/main/java/com/example/timecalculator/ui - Compose screens
- app/src/main/java/com/example/timecalculator/domain/model - TimeEntry entity
- app/src/main/java/com/example/timecalculator/domain/usecase - TimeCalculator logic
- app/src/main/java/com/example/timecalculator/presentation - ViewModel and UiState

GitHub Actions
--------------
- .github/workflows/debug-apk.yml builds a debug APK and uploads it as an artifact.
- .github/workflows/release-apk.yml (optional) builds and publishes a signed release APK to a GitHub Release — requires keystore secrets.

Notes
-----
- Debug APK is signed with the debug key; good for testing only.
- Release signing requires a keystore; keep passwords out of VCS.

License
-------
Add a LICENSE file as appropriate for your project.
