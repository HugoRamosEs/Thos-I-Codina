<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);
    
    require_once "bootstrap.php";
    
    try {
        $data = $em->getRepository(Data::class)->findOneBy(["data" => "17/04/2024"]);
        $event = $em->getRepository(Event::class)->findOneBy(["titol" => "Examen M07 UF3"]);
        $localitzacio = $em->getRepository(Localitzacio::class)->findOneBy(["lloc" => "IES Thos i Codina"]);
        $pagament = $em->getRepository(Pagament::class)->findOneBy(["referenciaExterna" => "0555477310DB003669"]);
        $zona = $em->getRepository(Zona::class)->findOneBy(["descripcio" => "Aula 19"]);
        
        $entrada = new Entrada();
        $entrada->setId("AAAAA11");
        $entrada->setButaca(20);
        $entrada->setFila(1);
        $entrada->setCompardor("1234567Z");
        $entrada->setData($data);
        $entrada->setEvent($event);
        $entrada->setLocalitzacio($localitzacio);
        $entrada->setPagament($pagament);
        $entrada->setZona($zona);
        $em->persist($entrada);
        
        $em->flush();
        
        echo "afegida";
        
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }