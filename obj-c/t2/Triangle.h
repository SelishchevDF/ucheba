//
//  Triangle.h


#import <Foundation/Foundation.h>
#import "Figure.h"
NS_ASSUME_NONNULL_BEGIN

@interface Triangle : Figure
@property (nonatomic, assign) CGFloat side1;
@property (nonatomic, assign) CGFloat side2;
@property (nonatomic, assign) CGFloat side3;

- (CGFloat)calculateArea;
- (CGFloat)calculatePerimeter;
@end

NS_ASSUME_NONNULL_END
