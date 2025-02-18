//
//  Circle.m


#import "Circle.h"

@implementation Circle
- (CGFloat)calculateArea {
    return M_PI * (self.radius * self.radius);
}

- (CGFloat)calculatePerimeter {
    return 2 * M_PI * self.radius;
}

- (void)printInfo {
    NSLog(@"Circle: radius=%.2f, area=%.2f, perimetr=%.2f", self.radius, [self calculateArea], [self calculatePerimeter]);
}

@end
