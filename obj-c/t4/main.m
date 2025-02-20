//
//  main.m
//  t4
//
// 
//

#import <Foundation/Foundation.h>
#import "Robot.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        NSString *(^upBlock)(void) = ^{
            return @"up";
        };
        NSString *(^downBlock)(void) = ^{
            return @"down";
        };
        NSString *(^leftBlock)(void) = ^{
            return @"left";
        };
        NSString *(^rightBlock)(void) = ^{
            return @"right";
        };
        
        Robot *robot = [Robot new];
        NSLog(@"Координаты робота: x - %d, y - %d.", robot.xCoordinate, robot.yCoordinate);
        [robot run:upBlock];
        [robot run:downBlock];
        [robot run:leftBlock];
        [robot run:rightBlock];
    }
    return 0;
}
