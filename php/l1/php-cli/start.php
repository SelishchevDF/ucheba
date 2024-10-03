<?php

$a = 5;
$b = '05';
var_dump($a == $b);
var_dump((int)'012345');
var_dump((float)123.0 === (int)123.0);
var_dump(0 == 'hello, world');

var_dump((int)'hello, world');
var_dump((int)0);

var_dump((string)0);
var_dump((string)'hello, world');

$a = 1;
$b = 2;
    
echo "a=". $a . " b=" . $b . " / ";

    $a = $a * $b;
    $b = $a / $b;
    $a = $a / $b;
    
echo "a=". $a . " b=" . $b;

/* docker run --rm -v ${pwd}/php-cli/:/cli php:8.2-cli php /cli/start.php
bool(true)
int(12345)
bool(false)
bool(false)
*/

/* docker run --rm -v ${pwd}/php-cli/:/cli php:7.4-cli php /cli/start.php
bool(true)
int(12345)
bool(false)
bool(true)
*/

// Я так понял в 7.4 он приводит к инту и сравнивает, а в 8.2 к строке и сравнивает



