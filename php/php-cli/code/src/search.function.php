<?php

function searchByBirthday(array $config) : string {
    $address = $config['storage']['address'];
    
    if (file_exists($address) && is_readable($address)) {
        $file = fopen($address, "rb");
        
        $contents = ''; 
    
        while (!feof($file)) {
            $contents .= fread($file, 100);
        }
        
        fclose($file);

        $data = explode("\r\n", $contents);    

        //$dateDay = date("d");
        //$dateMonth = date("m");
        $result = [];
        $wasFound = false;

        foreach ($data as $record){
            $recordData = explode(',', $record);
            $dateBlocks = explode("-", $recordData[1]);

            $day = (int) $dateBlocks[0];
            $month = (int) $dateBlocks[1];
            if($day == date("d") && ($month == date("m"))){
                $wasFound = true;
                array_push($result, $record);
            }
        }

        if ($wasFound){
            return implode("\r\n", $result);
        } 
        else {
            return "Записей c днем рождения сегодня не найдено";
        }

    }
    else {
        return handleError("Файл не существует");
    }
}