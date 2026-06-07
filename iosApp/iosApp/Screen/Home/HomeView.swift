import SwiftUI

struct HomeView: View {
    @EnvironmentObject var authVM: AuthViewModel

    private var displayName: String {
        authVM.userSession?.name ?? authVM.userSession?.username ?? "User"
    }

    var body: some View {
        VStack(spacing: 16) {
            Text("Home")
                .font(.system(size: 32, weight: .bold))
                .foregroundColor(ThemeColors.primary)

            Text("Welcome, \(displayName)!")
                .font(.title3)

            Text("You are signed in to Wheelhouse.")
                .font(.subheadline)
                .foregroundColor(.secondary)
                .multilineTextAlignment(.center)

            Button("Log Out") {
                authVM.logout()
            }
            .fontWeight(.semibold)
            .frame(maxWidth: .infinity)
            .padding(.vertical, 14)
            .background(ThemeColors.primary)
            .foregroundColor(.white)
            .cornerRadius(10)
            .padding(.top, 16)
        }
        .padding(24)
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color(.systemBackground))
    }
}
