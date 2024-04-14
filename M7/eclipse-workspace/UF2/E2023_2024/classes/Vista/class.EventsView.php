<?php
class EventsView {
    
    public static function show($events) {
        $events_list = "<ul class=\"events__list\">";
        foreach ($events as $event) {
            $events_list .= "<li class=\"events__item\"><div class=\"events__item--left\">";
            $events_list .= "<span class=\"events__name\">{$event['name']}</span>";
            $events_list .= "<span class=\"events__date\">{$event['from']}</span>";
            $class = (isset($event['tag']) && $event['tag']=="All day") ? "events__tag--highlighted" : "";
            $events_list .= (isset($event['tag'])) ? "</div><span class=\"events__tag $class\">{$event['tag']}</span></li>" : "</div></li>";
        }
        $ara = new DateTime();
        $diaActual = date("j",strtotime(date_format($ara,"Y-m-d")));
        $mesActual = date("n",strtotime(date_format($ara,"Y-m-d")));
        
        //Em posiciono 6 dies abans de la data actual.
        $ara->sub(DateInterval::createFromDateString('6 days'));
        
        //Em situo al primer diumenge abans de la data actual
        while (date("w",strtotime(date_format($ara,"Y-m-d"))) > 0) {
            $ara->add(DateInterval::createFromDateString('1 day'));
        }
        
        $calendar_table_body = "<div class=\"calendar-table__body\">";
        for ($j=0; $j<7; $j++) {
            $calendar_table_body .= "<div class=\"calendar-table__row\">";
            for($i=0; $i<7; $i++) {
                $dia = date("j",strtotime(date_format($ara,"Y-m-d")));
                $mes = date("n",strtotime(date_format($ara,"Y-m-d")));
                
                $type = ($mes==$mesActual || $mes==$mesActual+2) ? (($dia==$diaActual) ? " calendar-table__today" : " calendar-table__inactive") : "";
                
                //Miro si la date que estic dibuixant està a l'array d'events
                $auxData = $ara->format("Y-m-d");
                $class = "";
                foreach ($events as $event) {
                    if ($auxData == $event['from']) {
                        if (!isset($event['to'])) {
                            $class = "calendar-table__event";
                        } else {
                            $class = "calendar-table__event calendar-table__event--long calendar-table__event--start";
                        }
                    }
                    if (isset($event['from']) && isset($event['to'])) {
                        //                 $sDataInici = substr($event['from'],6,4) . '-' . substr($event['from'],3,2) . '-' . substr($event['from'],0,2);
                        $data_inici = strtotime($event['from']);
                        //                 $sDataFi = substr($event['to'],6,4) . '-' . substr($event['to'],3,2) . '-' . substr($event['to'],0,2);
                        $data_fi = strtotime($event['to']);
                        $data_ara = strtotime($ara->format('Y-m-d'));
                        if(($data_ara > $data_inici) && ($data_ara < $data_fi)) {
                            $class = " calendar-table__event calendar-table__event--long";
                        }
                    }
                    if (isset($event['to']) && $auxData == $event['to']) {
                        $class = " calendar-table__event calendar-table__event--long calendar-table__event--end";
                    }
                }
                $calendar_table_body .= "<div class=\"calendar-table__col $type $class\"><div class=\"calendar-table__item\"><span>$dia</span></div></div>";
                $ara->add(DateInterval::createFromDateString('1 day'));
            }
            $calendar_table_body .= "</div>";
        }
        $calendar_table_body .= "</div>";
        include 'templates/html.php';
    }
}