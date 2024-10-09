<?php

function deleteRecord(array $config) : string {
    $address = $config['storage']['address'];
    
    if (file_exists($address) && is_readable($address)) {
        $file = fopen($address, "rb");
        
        $contents = ''; 
    
        while (!feof($file)) {
            $contents .= fread($file, 100);
        }
        
        fclose($file);

        $data = explode("\r\n", $contents);    

        $date = readline("Введите имя или дату рождения в формате ДД-ММ-ГГГГ: ");

        $result = [];
        $wasFound = false;
        foreach ($data as $record){
            $recordData = explode(',', $record);
            if(!((isset($recordData[0]) && trim($recordData[0]) == $date) || 
                 (isset($recordData[1]) && trim($recordData[1]) == $date))){
                array_push($result, $record);
            } else {
                $wasFound = true;
            }
        }

        $dataToWrite = implode("\r\n", $result);

        $fileHandler = fopen($address, 'w');
        fwrite($fileHandler, $dataToWrite);
        fclose($fileHandler);

        if ($wasFound) {
            return "Записи, соответствующие указанному критерию, успешно удалены";
        } else {
            return "Записи, соответствующие указанному критерию, не найдены";
        }

        return "Записей с данной датой рождения не найдено";
    }
    else {
        return handleError("Файл не существует");
    }
}