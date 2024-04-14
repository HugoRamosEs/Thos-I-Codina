<?php
class EventModel {
    
    public static function read() {
        $events[] = array(
            "name" => "Examen M07 UF2",
            "from" => "2024-01-31",
            "tag"  => "17:00"
        );
        $events[] = array(
            "name" => "Entrega de la Pràctica M03 E10 Escacs",
            "from" => "2024-02-04",
            "tag"  => "23:55"
        );
        $events[] = array(
            "name" => "Examen M03 UF5",
            "from" => "2024-02-06",
            "tag"  => "16:15"
        );
        $events[] = array(
            "name" => "Vacances.... podeu descansar",
            "from" => "2024-02-12",
            "to" => "2024-02-18",
            "tag" => "All day"
        );
        return $events;
    }
    
    public static function getOneById($event) {
        
    }
}