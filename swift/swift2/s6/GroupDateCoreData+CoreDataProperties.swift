//
//  GroupDateCoreData+CoreDataProperties.swift
//  t1
//
//  Created by selishchev on 23.02.2025.
//
//

import Foundation
import CoreData


extension GroupDateCoreData {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<GroupDateCoreData> {
        return NSFetchRequest<GroupDateCoreData>(entityName: "GroupDateCoreData")
    }

    @NSManaged public var date: Date?

}

extension GroupDateCoreData : Identifiable {

}
