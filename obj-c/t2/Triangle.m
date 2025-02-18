//
//  Triangle.m


#import "Triangle.h"

@implementation Triangle
- (CGFloat)calculateArea {
    CGFloat s = (self.side1 + self.side2 + self.side3) / 2;
    CGFloat area = sqrt(s * (s - self.side1) * (s - self.side2) * (s - self.side3));
    return area;
}

- (CGFloat)calculatePerimeter {
    return self.side1 + self.side2 + self.side3;
}

- (void)printInfo {
    NSLog(@"Triangle: side1=%.2f, side2=%.2f, side2=%.2f, area=%.2f, perimetr=%.2f", self.side1, self.side2, self.side3, [self calculateArea], [self calculatePerimeter]);
}

@end
