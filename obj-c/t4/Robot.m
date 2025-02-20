//
//  Robot.m
//  t4
//
//  
//

#import "Robot.h"

@implementation Robot
- (instancetype)init {
    self = [super init];
    if (self) {
        _xCoordinate = _yCoordinate = 0;
    }
    return self;
}

- (void)run:(NSString *(^)(void))directionBlock {
    NSString *blockResult = directionBlock();
    if ([blockResult  isEqual: @"up"]) {
        _yCoordinate++;
        NSLog(@"Робот двигается вверх, новые координаты: x - %d, y - %d.", _xCoordinate, _yCoordinate);
    } else if ([blockResult  isEqual: @"down"]) {
        _yCoordinate--;
        NSLog(@"Робот двигается вниз, новые координаты: x - %d, y - %d.", _xCoordinate, _yCoordinate);
    } else if ([blockResult  isEqual: @"left"]) {
        _xCoordinate--;
        NSLog(@"Робот двигается влево, новые координаты: x - %d, y - %d.", _xCoordinate, _yCoordinate);
    } else if ([blockResult  isEqual: @"right"]) {
        _xCoordinate++;
        NSLog(@"Робот двигается вправо, новые координаты: x - %d, y - %d.", _xCoordinate, _yCoordinate);
    } else {
        NSLog(@"Сам туда иди");
    }
}

@end
