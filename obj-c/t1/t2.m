
// Решить квадратные уравнения:
// x^2 – 8x + 12 = 0,
// 12x^2 – 4x + 2 = 0,
// x^2 – 100x - 2 = 0
// (заменять константы в коде).

#import <Foundation/Foundation.h>
#import <math.h>

void sqrtSolve(float a, float b, float c) {
    float D = (b * b) - (4 * a * c);
    if (D < 0) {
        NSLog(@"нет корней");
    } else if (D == 0) {
        float answ = (-b + sqrt(D)) / 2 * a;
        NSLog(@"один корень %f", answ);
    } else if (D > 0) {
        float answ1 = (-b + sqrt(D)) / 2 * a;
        float answ2 = (-b - sqrt(D)) / 2 * a;
        NSLog(@"первый корень %f, второй корень %f", answ1, answ2);
    }
}

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        float a = 1.f;
        float b = -8.f;
        float c = 12.f;
        sqrtSolve(a, b, c);
        a = 12.f;
        b = -4.f;
        c = 2.f;
        sqrtSolve(a, b, c);
        a = 1.f;
        b = -100.f;
        c = -2.f;
        sqrtSolve(a, b, c);
    }
    return 0;
}
