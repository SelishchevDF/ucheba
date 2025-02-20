//
//  Robot.h
//  t4
//
// 
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Robot : NSObject

@property (nonatomic, readonly) int xCoordinate;
@property (nonatomic, readonly) int yCoordinate;

-(void)run:(NSString *(^)(void))directionBlock;

@end

NS_ASSUME_NONNULL_END
