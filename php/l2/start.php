<?php

//1. Реализовать основные 4 арифметические операции в виде функции с тремя параметрами – два параметра это числа, третий – операция. Обязательно использовать оператор return.

$a = 11;
$b = 22;
$operator = "+";

function mathOperation111($arg1, $arg2, $operation){
    if($operation == "+")
        return $arg1 + $arg2;
    if($operation == "-")
        return $arg1 - $arg2;
    if($operation == "*")
        return $arg1 * $arg2;
    if($operation == "/")
        return $arg1 / $arg2;
    return "oops";       

}

echo mathOperation111($a, $b, $operator) . "\n";


/*2. Реализовать функцию с тремя параметрами: function mathOperation($arg1, $arg2, $operation), где $arg1, $arg2 – значения аргументов, 
$operation – строка с названием операции. В зависимости от переданного значения операции выполнить одну из арифметических операций 
(использовать функции из пункта 3) и вернуть полученное значение (использовать switch).
*/

function  mathOperation($arg1, $arg2, $operation)
{
    switch ($operation)
    {
        case "+":
            return $arg1 + $arg2;
            break;
        case "-":
            return $arg1 - $arg2;
            break;
        case "*":
            return $arg1 * $arg2;
            break;
        case "/":
            return $arg1 / $arg2;
            break;
        default:

            return "oops";
    }
}

echo mathOperation($a, $b, $operator) . "\n";


/*3. Объявить массив, в котором в качестве ключей будут использоваться названия областей, а в качестве значений – массивы с названиями городов из соответствующей области.
Вывести в цикле значения массива, чтобы результат был таким: Московская область: Москва, Зеленоград, Клин Ленинградская область: Санкт-Петербург,
Всеволожск, Павловск, Кронштадт Рязанская область … (названия городов можно найти на maps.yandex.ru).
*/

$regions = ["Московская область" => ["Москва", "Зеленоград"], "Ленинградская область"=> ["Санкт-Петербург", "Всеволожск", "Павловск", "Кронштадт"]];

foreach($regions as $region => $towns)
{
    echo $region . ": ";
    for ($i = 0; $i < count($towns); $i++)
    {
		if($i < count($towns) - 1){
			echo $towns[$i] . ", ";
		}
		else{
			echo $towns[$i] . "\n";
		}
    }
}



/*4. Объявить массив, индексами которого являются буквы русского языка, а значениями – соответствующие латинские буквосочетания 
(‘а’=> ’a’, ‘б’ => ‘b’, ‘в’ => ‘v’, ‘г’ => ‘g’, …, ‘э’ => ‘e’, ‘ю’ => ‘yu’, ‘я’ => ‘ya’). Написать функцию транслитерации строк.
*/

$string = "123 ЮЮЮЮ здравствуй";

$alfabet = [
    'а' => 'a', 'б' => 'b', 'в' => 'v',
    'г' => 'g', 'д' => 'd', 'е' => 'e',
    'ё' => 'e', 'ж' => 'zh', 'з' => 'z',
    'и' => 'i', 'й' => 'y', 'к' => 'k',
    'л' => 'l', 'м' => 'm', 'н' => 'n',
    'о' => 'o', 'п' => 'p', 'р' => 'r',
    'с' => 's', 'т' => 't', 'у' => 'u',
    'ф' => 'f', 'х' => 'h', 'ц' => 'c',
    'ч' => 'ch', 'ш' => 'sh', 'щ' => 'shch',
    'ь' => '\'', 'ы' => 'y', 'ъ' => '\'',
    'э' => 'e', 'ю' => 'yu', 'я' => 'ya',
];

function translate($string, $alfabet) {
    $result = "";
    $length = mb_strlen($string);
    
    for ($i = 0; $i < $length; $i ++)
    {
    	//$char = mb_substr($string, $i, 1);
    	
        $char = mb_strtolower(mb_substr($string, $i, 1));

    	if (isset($alfabet[$char])) {
    		$new_char = $alfabet[$char];	
    	}
    	else {
    		$new_char = $char;
    	}
    	$result .= $new_char;
    }
    return $result;
}


echo $string . " => " . translate($string, $alfabet);

// docker run --rm -v ${pwd}/:/cli php:8.2-cli php /cli/start.php
