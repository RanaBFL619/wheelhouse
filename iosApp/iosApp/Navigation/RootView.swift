import SwiftUI

struct RootView: View {
    @StateObject private var authVM = AuthViewModel()

    var body: some View {
        Group {
            switch authVM.authState {
            case .loggedIn:
                HomeView()
                    .environmentObject(authVM)
            case .loading:
                ProgressView("Signing in…")
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
            case .idle, .error:
                LoginView()
                    .environmentObject(authVM)
            }
        }
        .alert("Sign In Error", isPresented: $authVM.showError) {
            Button("OK", role: .cancel) {
                authVM.clearError()
            }
        } message: {
            Text(authVM.errorMessage)
        }
    }
}
