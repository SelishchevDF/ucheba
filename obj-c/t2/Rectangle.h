//
//  Rectangle.h


#import <Foundation/Foundation.h>
#import "Figure.h"

NS_ASSUME_NONNULL_BEGIN

@interface Rectangle : Figure

@property CGFloat width;
@property CGFloat height;

- (CGFloat)calculateArea;
- (CGFloat)calculatePerimeter;

@end

NS_ASSUME_NONNULL_END
