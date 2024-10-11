<?php

/*
class A {
    public function foo() {
    static $x = 0;
    echo ++$x;
    }
    }
    $a1 = new A();
    $a2 = new A();
    $a1->foo(); //1
    $a2->foo(); //2
    $a1->foo(); //3
    $a2->foo(); //4
*/

//поле статическое - одно на всех

/*
class A {
    public function foo() {
    $x = 0;
    echo ++$x;
    }
    }
    class B extends A {
    }
    $a1 = new A();
    $b1 = new B();
    $a1->foo(); //1
    $b1->foo(); //2
    $a1->foo(); //3
    $b1->foo(); //4
*/

abstract class Book {

    protected string $name;
    protected string $description;
    private int $usingCount;
    
    public function __construct(string $name, string $description) {
        $this->name = $name;
        $this->description = $description;
    }

    public function giveBook() {
        $this->usingCount += 1;
    }

}

class elBook extends Book {

    private string $url;

    public function __construct(string $name, string $description, string $url)
    {
        parent::__construct($name, $description);
        $this->url = $url;
        $this->usingCount = 5;
    }

    public function giveBook() {
        $this->usingCount += 1;
        return $this->url . " скачано " . $this->usingCount . "\n";
    }
}

class paperBook extends Book {

    private string $adress;

    public function __construct(string $name, string $description, string $adress)
    {
        parent::__construct($name, $description);
        $this->adress =  $adress;
        $this->usingCount = 50;
    }

    public function giveBook() {
        $this->usingCount += 1;
        return $this->adress . " выдано " . $this->usingCount . "\n";
    }
}

$eb1 = new elBook('qwer', 'qwer', 'qwer');
$eb2 = new elBook('qwer11', 'qwer11', 'qwer11');

$pb = new paperBook('asdf', 'asdf', 'asdf');
$pb2 = new paperBook('asdf11', 'asdf11', 'asdf11');

echo $eb1->giveBook();
echo $eb1->giveBook();
echo $eb1->giveBook();
echo $eb1->giveBook();

echo $pb2->giveBook();
echo $pb2->giveBook();

// docker run --rm -v ${pwd}/:/cli php:7.4-cli php /cli/start.php
