<?php

function validate(string $date) : bool {
    
    $days_in_month = array(1 => 31, 2 => 28, 3 => 31, 4 => 30, 5 => 31, 6 => 30, 7 => 31, 8 => 31, 9 => 30, 10 => 31, 11 => 30, 12 => 31);

    $dateBlocks = explode("-", $date);

    if(count($dateBlocks) != 3){
        return false;
    }

    $day = (int) $dateBlocks[0];
    $month = (int) $dateBlocks[1];
    $year = (int) $dateBlocks[2];

    if($year > (int) date('Y')) {
        return false;
    }

    if($month > 12) {
        return false;
    }

    if($day > $days_in_month[$month]) {
        return false;
    }

    return true;

}