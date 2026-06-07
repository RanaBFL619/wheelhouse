import SwiftUI
import shared

struct UserSessionData {
    let token: String
    let name: String?
    let username: String
    let roles: [String]
    let defaultPage: String?
}

@MainActor
final class AuthViewModel: ObservableObject {

    enum AuthState: Equatable {
        case idle
        case loading
        case loggedIn
        case error(String)
    }

    @Published private(set) var authState: AuthState = .idle
    @Published private(set) var userSession: UserSessionData? = nil
    @Published var showError = false
    @Published var errorMessage = ""

    private let sharedVM: AuthSharedViewModel

    init() {
        sharedVM = WheelhouseKoin.shared.getAuthViewModel()
        authState = .loading
        sharedVM.collectAuthStateSnapshot { [weak self] snapshot in
            DispatchQueue.main.async {
                self?.updateState(from: snapshot)
            }
        }
    }

    func login(username: String, password: String) {
        sharedVM.login(username: username, password: password)
    }

    func logout() {
        sharedVM.logout()
    }

    func clearError() {
        sharedVM.clearError()
        showError = false
        errorMessage = ""
    }

    private func updateState(from snapshot: AuthStateSnapshot) {
        switch snapshot.kind {
        case "success":
            if let s = snapshot.session {
                userSession = UserSessionData(
                    token: s.token,
                    name: s.name,
                    username: s.username,
                    roles: Array(s.roles),
                    defaultPage: s.defaultPage
                )
            }
            authState = .loggedIn
            showError = false
        case "loading":
            authState = .loading
        case "error":
            userSession = nil
            authState = .error(snapshot.errorMessage ?? "Error")
            errorMessage = snapshot.errorMessage ?? "Sign in failed"
            showError = true
        default:
            userSession = nil
            authState = .idle
            showError = false
        }
    }
}
