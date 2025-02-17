
// Создать программу, которая находит большее число среди 3-х чисел.

#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        int a = 10;
        int b = 20;
        int c = 15;
        
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        NSLog(@"Максимальное число %d", max);
    }
    return 0;
}
