<?php
//     error_reporting(E_ALL);
//     ini_set('display_errors', 1);
    
    require_once "bootstrap.php";
    
    use Frases\Entity\Autor;
    use Frases\Entity\Tema;
    use Frases\Entity\Frase;
    
//     CREAR FRASES
    try {
        $tema_pensament = $entityManager->getRepository(Tema::class)->findOneBy(["nombre" => "Pensament"]);
        $tema_aprendre = $entityManager->getRepository(Tema::class)->findOneBy(["nombre" => "Aprendre"]);
        
        $frase = new Frase();
        $frase->setTexto("Cogito, ergo sum");
        $frase->setAutor($entityManager->getRepository(Autor::class)->findOneBy(["nombre" => "Descartes"]));
        $frase->addTema($tema_pensament);
//         $frase->setTemes([$tema_pensament]); // --> Otra forma
        $entityManager->persist($frase);
        
        
        $frase2 = new Frase();
        $frase2->setTexto("Aprendre sense pensar és treball perdut; pensar sense aprendre és perillós.");
        $frase2->setAutor($entityManager->getRepository(Autor::class)->findOneBy(["nombre" => "Confuccio"]));
        $frase2->addTema($tema_aprendre);
        $frase2->addTema($tema_pensament);
//         $frase2->setTemes([$tema_aprendre, $tema_pensament]); // --> Otra forma
        $entityManager->persist($frase2);

        $entityManager->flush();
        
        echo "Frases creades";
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }