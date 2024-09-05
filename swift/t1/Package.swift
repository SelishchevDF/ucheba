// swift-tools-version: 5.10
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "t1",
    products: [
        // Products define the executables and libraries a package produces, making them visible to other packages.
        .executable(
            name: "t1",
            targets: ["t1"]),
    ],
    targets: [
        // Targets are the basic building blocks of a package, defining a module or a test suite.
        // Targets can depend on other targets in this package and products from dependencies.
        .target(
            name: "t1"),
        .testTarget(
            name: "t1Tests",
            dependencies: ["t1"]),
    ]
)
