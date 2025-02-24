//
//  FriendModelCoreData+CoreDataProperties.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//
//

import Foundation
import CoreData


extension FriendModelCoreData {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<FriendModelCoreData> {
        return NSFetchRequest<FriendModelCoreData>(entityName: "FriendModelCoreData")
    }

    @NSManaged public var firstName: String?
    @NSManaged public var id: Int64
    @NSManaged public var lastName: String?
    @NSManaged public var online: Int16
    @NSManaged public var photo: String?

}

extension FriendModelCoreData : Identifiable {

}
