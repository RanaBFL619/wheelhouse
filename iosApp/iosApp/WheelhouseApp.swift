import SwiftUI
import shared

@main
struct WheelhouseApp: App {
    init() {
        IosKoinSetup.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            RootView()
        }
    }
}
