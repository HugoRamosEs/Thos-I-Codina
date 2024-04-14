<?php
//     error_reporting(E_ALL);
//     ini_set('display_errors', 1);
    
    require_once "bootstrap.php";
    
    use Frases\Entity\Autor;
    use Frases\Entity\Tema;
    use Frases\Entity\Frase;
    
//     ACTUALITZAR AUTORS
    try {
        $autor_id = 1;
        $autor_nombre = "Descartes";
        
        $autor = $entityManager->getRepository(Autor::class)->find($autor_id);
        $autor->setNombre("Hugo");
        $entityManager->persist($autor);
    
        $autor2 = $entityManager->getRepository(Autor::class)->findOneBy(['nombre' => $autor_nombre]);
        $autor2->setDescripcion("Gran pensador francés");
        $entityManager->persist($autor2);
        
        $entityManager->flush();
    
        echo "Actualitzats";
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }
    
//     CREAR AUTORS I TEMES 
//     try {
//         $autor1 = new Autor();
//         $autor1->setNombre("Confuccio");
//         $autor1->setDescripcion("Pensador xinès");
//         $entityManager->persist($autor1);
        
//         $autor2 = new Autor();
//         $autor2->setNombre("Descartes");
//         $autor2->setDescripcion("Filòsof i matemàtic francès");
//         $entityManager->persist($autor2);
        
//         $autor3 = new Autor();
//         $autor3->setNombre("Hesíode");
//         $autor3->setDescripcion("Poeta de l'Antiga Grècia");
//         $entityManager->persist($autor3);
        
//         $temes = array("Aprendre","Pensament","Vida","Justícia","Esperança");
//         foreach ($temes as $t){
//             $tema = new Tema();
//             $tema->setNombre($t);
//             $entityManager->persist($tema);
//         }
        
//         $entityManager->flush();
        
//         echo "Funciona";
//     } catch (Exception $e) {
//         echo "Error: " . $e->getMessage();
//     }
    
//     LLEGIR AUTORS I TEMES
//     try {
//         echo "AUTORS:<br>";
//         $autors = $entityManager->getRepository('Frases\Entity\Autor')->findAll();
//         foreach ($autors as $a){
//             echo "- " . $a->getNombre() . "<br>";
//         }
        
//         echo "<br>TEMES:<br>";
//         $temes = $entityManager->getRepository('Frases\Entity\Tema')->findAll();
//         foreach ($temes as $t){
//             echo "- " . $t->getNombre() . "<br>";
//         }
//     } catch (Exception $e) {
//         echo "Error: " . $e->getMessage();
//     }