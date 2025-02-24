//
//  PrepareView.swift
//  t1
//
//  Created by selishchev on 22.02.2025.
//

import SwiftUI
import Foundation

struct PrepareView: View {
    var body: some View {
        NavigationStack {
            NavigationLink("Читать новости", destination: ContentView ())
        }
    }
}

struct NewsView_Previews: PreviewProvider {
    static var previews:
        some View {
        PrepareView()
    }
}
