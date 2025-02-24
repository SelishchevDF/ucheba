//
//  GroupModelCoreData+CoreDataProperties.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//
//

import Foundation
import CoreData


extension GroupModelCoreData {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<GroupModelCoreData> {
        return NSFetchRequest<GroupModelCoreData>(entityName: "GroupModelCoreData")
    }

    @NSManaged public var caption: String?
    @NSManaged public var id: Int64
    @NSManaged public var name: String?
    @NSManaged public var photo: String?

}

extension GroupModelCoreData : Identifiable {

}
