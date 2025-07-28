import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        InitDependencyInjectionKt.StartDI()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
