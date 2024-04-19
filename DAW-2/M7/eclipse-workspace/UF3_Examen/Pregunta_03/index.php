<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);
    
    require_once "bootstrap.php";
    
    try {
        $data = new Data();
        $data->setData("17/04/2024");
        $data->setHora("16:55");
        $em->persist($data);
        
        $event = new Event();
        $event->setTitol("Examen M07 UF3");
        $event->setSubtitol("Primera convocatoria");
        $event->setImatge("-");
        $em->persist($event);
        
        $localitzacio = new Localitzacio();
        $localitzacio->setLloc("IES Thos i Codina");
        $localitzacio->setAdreca("Riera de Cirera 57 - 08304");
        $localitzacio->setLocalitat("Mataró");
        $em->persist($localitzacio);
        
        $pagament = new Pagament();
        $pagament->setBanc("0049");
        $pagament->setReferenciaExterna("0555477310DB003669");
        $pagament->setData("17/04/2024");
        $pagament->setEstat("pagat");
        $em->persist($pagament);
        
        $zona = new Zona();
        $zona->setDescripcio("Aula 19");
        $em->persist($zona);
        
        $em->flush();
        
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }
?>