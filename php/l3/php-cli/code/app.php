<?php

// подключение файлов логики
// require_once('src/main.function.php');
// require_once('src/template.function.php');
// require_once('src/file.function.php');

require_once('vendor/autoload.php');
require_once('src/validate.function.php');
require_once('src/search.function.php');
require_once('src/delete.function.php');

// вызов корневой функции
$result = main("/code/config.ini");
// вывод результата
echo $result; 


// !!! PS C:\Users\Selishchev\Desktop\php\l3\php-cli> docker run -it -v ${pwd}/code:/code/ php:8.2-cli php code/app.php