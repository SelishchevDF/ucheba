//
//  FriendDateCoreData+CoreDataProperties.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//
//

import Foundation
import CoreData


extension FriendDateCoreData {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<FriendDateCoreData> {
        return NSFetchRequest<FriendDateCoreData>(entityName: "FriendDateCoreData")
    }

    @NSManaged public var date: Date?

}

extension FriendDateCoreData : Identifiable {

}
