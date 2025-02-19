//
//  Doctor.h
//  t3
//
//  
//

#import <Foundation/Foundation.h>
#import "DoctorDelegate.h"
#import "Patient.h"

NS_ASSUME_NONNULL_BEGIN

@interface Doctor : NSObject

@property (nonatomic, weak, nullable) id<DoctorDelegate> delegate;
- (void) takePills;


@end

NS_ASSUME_NONNULL_END
