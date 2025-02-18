//
//  Rectangle.m


#import "Rectangle.h"

@implementation Rectangle

- (CGFloat)calculateArea {
    return self.width * self.height;
}

- (CGFloat)calculatePerimeter {
    return 2 * (self.width + self.height);
}

- (void)printInfo {
    NSLog(@"Rectangle: width=%.2f, height=%.2f, area=%.2f, perimetr=%.2f", self.width, self.height, [self calculateArea], [self calculatePerimeter]);
}

@end
