import Foundation
import shared

enum IosKoinSetup {
    static func doInitKoin() {
        WheelhouseKoin.shared.doInitKoin(platformContext: nil as Any?)
    }
}
