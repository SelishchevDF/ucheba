//
//  main.m


#import <Foundation/Foundation.h>
#import "Circle.h"
#import "Rectangle.h"
#import "Triangle.h"
int main(int argc, const char * argv[]) {
    @autoreleasepool {
        
        NSMutableArray *figures = [[NSMutableArray alloc] initWithCapacity:3];
        
        Rectangle *rectangle = [[Rectangle alloc] init];
        rectangle.width = 5;
        rectangle.height = 10;
        [figures addObject:rectangle];
        
        Circle *circle = [[Circle alloc] init];
        circle.radius = 3;
        [figures addObject:circle];
        
        Triangle *triangle = [[Triangle alloc] init];
        triangle.side1 = 3;
        triangle.side2 = 4;
        triangle.side3 = 5;
        [figures addObject:triangle];
        
        for (Figure *figure in figures) {
            [figure printInfo];
        }
    }
    return 0;
}
